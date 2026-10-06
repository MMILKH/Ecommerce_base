package controller;

import dao.CarrelloDao;
import dao.ProdottoDao;
import dao.RigaCarrelloDao;
import model.Carrello;
import model.Prodotto;
import model.RigaCarrello;
import model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/carrello")
public class CarrelloServlet extends HttpServlet {

    CarrelloDao carrelloDao;
    ProdottoDao prodottoDao;
    RigaCarrelloDao rigaCarrelloDao;


    @Override
    public void init() {
        carrelloDao = new CarrelloDao();
        prodottoDao = new ProdottoDao();
        rigaCarrelloDao = new RigaCarrelloDao();


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession(false);

        double totale = 0;

        Utente u = null;

        if (session == null || session.getAttribute("utenteLoggato") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        } else {
            u = (Utente) session.getAttribute("utenteLoggato");
        }

        Carrello c = carrelloDao.findByUtenteId(u.getId());
        List<RigaCarrello> righe = rigaCarrelloDao.findByCarrelloId(c.getId());
        List<Prodotto> prodotti = new ArrayList<>();
        Map<Integer, Integer> quantitaxprodotto = new HashMap<>();
        for (RigaCarrello r : righe) {
            quantitaxprodotto.put((Integer) r.getProdotto().getId(), (Integer) r.getQuantita());
            Prodotto p = prodottoDao.findById(r.getProdotto().getId());
            prodotti.add(p);

            totale += p.getPrezzo() * r.getQuantita();

        }
        request.setAttribute("listaProdotti", prodotti);
        request.setAttribute("listaQuantita", quantitaxprodotto);
        request.setAttribute("totale", totale);

        request.getRequestDispatcher("/carrello.jsp").forward(request, response);


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        String azione = request.getParameter("azione");


        Utente u = null;

        if (azione == null || azione.equals("")) {

            response.sendRedirect(request.getContextPath() + "/carrello");
            return;
        }
        switch (azione) {
            case "aggiornaq":
                if (session != null) {
                    u = (Utente) session.getAttribute("utenteLoggato");
                    Carrello c = carrelloDao.findByUtenteId(u.getId());
                    Prodotto p = prodottoDao.findById(Integer.parseInt(request.getParameter("prodottoId")));
                    rigaCarrelloDao.updateQuantita(c.getId(), p.getId(), Integer.parseInt(request.getParameter("quantita")));
                    int id = u.getId();
                    Carrello carrello = carrelloDao.findByUtenteId(id);
                    carrello.setUltimoAggiornamento(new java.util.Date());
                    carrelloDao.updateUltimoAggiornamento(carrello);
                    response.sendRedirect(request.getContextPath() + "/carrello");
                    break;
                }
            case "rimuovi":
                if (session != null) {
                    u = (Utente) session.getAttribute("utenteLoggato");
                    Carrello c = carrelloDao.findByUtenteId(u.getId());
                    Prodotto p = prodottoDao.findById(Integer.parseInt(request.getParameter("prodottoId")));
                    rigaCarrelloDao.delete(c.getId(), p.getId());
                    int id = u.getId();
                    Carrello carrello = carrelloDao.findByUtenteId(id);
                    carrello.setUltimoAggiornamento(new java.util.Date());
                    carrelloDao.updateUltimoAggiornamento(carrello);
                    response.sendRedirect(request.getContextPath() + "/carrello");
                    break;
                }
        }


    }
}
