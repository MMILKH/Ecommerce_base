package controller;

import dao.UtenteDao;
import model.Utente;
import util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UtenteDao utenteDao;

    @Override
    public void init() throws ServletException {
        this.utenteDao = new UtenteDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String azione = request.getParameter("azione");

        if (azione == null || azione.equals("")) {

        }else if (azione.equals("logout")) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String email = request.getParameter("email");
        String passwordChiaro = request.getParameter("password");
        String password;
        try {
            password = Password.getHash(passwordChiaro);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


        if (email == null || email.trim().isEmpty() || passwordChiaro == null || passwordChiaro.trim().isEmpty()) {
            request.setAttribute("errore", "Compila tutti i campi obbligatori.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }


        Utente utente = utenteDao.findByEmail(email);


        if (utente != null && utente.getPassword().equals(password)) {


            HttpSession session = request.getSession();
            session.setAttribute("utenteLoggato", utente);


            response.sendRedirect(request.getContextPath() + "/catalogo");

        } else {

            request.setAttribute("errore", "Email o password non validi.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}