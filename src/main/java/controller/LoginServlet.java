package controller;

import dao.UtenteDao;
import model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UtenteDao utenteDao;

    @Override
    public void init() throws ServletException {
        this.utenteDao = new UtenteDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            request.setAttribute("errore", "Compila tutti i campi obbligatori.");
            request.getRequestDispatcher("/luj.jsp").forward(request, response);
            return;
        }


        Utente utente = utenteDao.findByEmail(email);


        if (utente != null && utente.getPassword().equals(password)) {


            HttpSession session = request.getSession(true);
            session.setAttribute("utenteLoggato", utente);


            response.sendRedirect(request.getContextPath() + "/catalogo");

        } else {

            request.setAttribute("errore", "Email o password non validi.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}