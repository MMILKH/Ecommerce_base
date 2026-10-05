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


@WebServlet("/aggiungiCarrello")
public class AggiungiCarrelloServlet extends HttpServlet {


    private CarrelloDao carrelloDao;
    private RigaCarrelloDao rigaCarrelloDao;
    private ProdottoDao prodottoDao;

    @Override
    public void init() throws ServletException {

        carrelloDao = new CarrelloDao();
        rigaCarrelloDao = new RigaCarrelloDao();
        prodottoDao = new ProdottoDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Utente u = null;
        if (session != null) {
            u = (Utente) session.getAttribute("utenteLoggato");

            Carrello c = carrelloDao.findByUtenteId(u.getId());
            int qta = Integer.parseInt(request.getParameter("quantita"));
            Prodotto p = prodottoDao.findById(Integer.parseInt(request.getParameter("prodottoId")));
            RigaCarrello r = new RigaCarrello(c, p, qta, new java.util.Date());
            rigaCarrelloDao.save(r);
        }

        response.sendRedirect(request.getContextPath() + "/catalogo");
    }
}
