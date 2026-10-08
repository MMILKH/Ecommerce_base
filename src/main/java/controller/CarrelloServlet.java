package controller;

import dao.CarrelloDao;
import dao.ProdottoDao;
import dao.RigaCarrelloDao;
import model.Carrello;
import model.RigaCarrello;
import model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


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


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("utenteLoggato") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        Utente u = (Utente) session.getAttribute("utenteLoggato");
        Carrello c = carrelloDao.findNewByUtenteId(u.getId());
        List<RigaCarrello> righe = rigaCarrelloDao.findByCarrelloId(c.getId());
        BigDecimal totale = BigDecimal.ZERO;
        for (RigaCarrello r : righe) {
            BigDecimal prezzoProdotto = r.getProdotto().getPrezzo();
            BigDecimal subtotale = prezzoProdotto.multiply(BigDecimal.valueOf(r.getQuantita()));
            totale = totale.add(subtotale);
        }
        request.setAttribute("listaRighe", righe);
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

        int rigaCarrelloId = Integer.parseInt(request.getParameter("rigaCarrelloId"));

        switch (azione) {
            case "aggiornaq":
                if (session != null) {
                    RigaCarrello rc = rigaCarrelloDao.findById(rigaCarrelloId);
                    rigaCarrelloDao.updateQuantita(rc.getId(), Integer.parseInt(request.getParameter("quantita")));
                    response.sendRedirect(request.getContextPath() + "/carrello");
                    break;
                }
            case "rimuovi":
                if (session != null) {
                    RigaCarrello rc = rigaCarrelloDao.findById(rigaCarrelloId);
                    rigaCarrelloDao.delete(rc.getId());
                    response.sendRedirect(request.getContextPath() + "/carrello");
                    break;
                }
        }


    }
}
