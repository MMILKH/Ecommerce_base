package controller;

import dao.ProdottoDao;
import model.Prodotto;
import model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/catalogo")
public class CatalogoServlet extends HttpServlet {
    private ProdottoDao prodottoDao;

    @Override
    public void init() throws ServletException {
        prodottoDao = new ProdottoDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);


        if (session != null) {
            Utente u = (Utente) session.getAttribute("utenteLoggato");
            request.setAttribute("utenteLoggato", u);
        }

        String categoria = request.getParameter("categoria");

        List<Prodotto> prodotti;


        if (categoria == null || categoria.isEmpty()) {
            prodotti = prodottoDao.findAll();

        } else {

            prodotti = prodottoDao.findByCategoria(categoria);
        }

        request.setAttribute("listaProdotti", prodotti);
        request.getRequestDispatcher("/catalogo.jsp").forward(request, response);
    }
}
