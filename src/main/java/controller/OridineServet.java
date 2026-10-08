package controller;


import dao.*;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@WebServlet("/ordine")
public class OridineServet extends HttpServlet {

    CarrelloDao carrelloDao;
    ProdottoDao prodottoDao;
    RigaCarrelloDao rigaCarrelloDao;
    OrdineDao ordineDao;
    RigaOrdineDao rigaOrdineDao;
    StatoDao statoDao;

    @Override
    public void init() {
        carrelloDao = new CarrelloDao();
        prodottoDao = new ProdottoDao();
        rigaCarrelloDao = new RigaCarrelloDao();
        ordineDao = new OrdineDao();
        rigaOrdineDao = new RigaOrdineDao();
        statoDao = new StatoDao();

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Utente u = null;
        Ordine o = new Ordine();

        if (session == null || session.getAttribute("utenteLoggato") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            u = (Utente) session.getAttribute("utenteLoggato");
            BigDecimal totale;
            Carrello c = carrelloDao.findNewByUtenteId(u.getId());
            Stato s = statoDao.findByCodice("PEN");
            List<RigaCarrello> righeC = rigaCarrelloDao.findByCarrelloId(c.getId());
            o.setDataCreazione(new java.util.Date());
            double temp = Double.parseDouble(request.getParameter("totale"));
            totale = BigDecimal.valueOf(temp);
            o.setImportoTotale(totale);
            o.setUtente(u);
            o.setStato(s);
            String indirizzoS = request.getParameter("indirizzoS");
            String indirizzoF = request.getParameter("indirizzoF");
            if (indirizzoF == null) {
                indirizzoF = "";
                o.setIndirizzoFatturazione(indirizzoF);
            } else {
                o.setIndirizzoFatturazione(indirizzoF);
            }

            o.setIndirizzoSpedizione(indirizzoS);
            o.setCodice(UUID.randomUUID().toString());

            ordineDao.save(o);
            BigDecimal temp2;

            for (RigaCarrello r : righeC) {
                RigaOrdine rO = new RigaOrdine();
                rO.setOrdine(o);
                temp2 = r.getProdotto().getPrezzo().multiply(BigDecimal.valueOf(r.getQuantita()));
                rO.setPrezzoRiga(temp2);
                rO.setProdotto(r.getProdotto());
                rO.setDataCreazione(new java.util.Date());
                rO.setQuantita(r.getQuantita());
                rO.setRigaCarrelloId(r.getId());
                rO.setPrezzoUnitario(r.getProdotto().getPrezzo());
                rigaOrdineDao.save(rO);
                rigaCarrelloDao.updateUltimaModifica(r.getId());

            }

            carrelloDao.updateStato(c.getId());
            Carrello carrelloNew = new Carrello();
            carrelloNew.setUtente(u);
            carrelloNew.setStato("NEW");
            carrelloNew.setDataCreazione(new java.util.Date());
            carrelloNew.setUltimoAggiornamento(new java.util.Date());
            carrelloDao.save(carrelloNew);

        }
        response.sendRedirect(request.getContextPath() + "/catalogo");


    }

}

