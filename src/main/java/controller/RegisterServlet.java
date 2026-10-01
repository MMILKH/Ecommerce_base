package controller;

import dao.UtenteDao;
import model.Carrello;
import model.Utente;
import util.Password;
import dao.CarrelloDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {


    UtenteDao utenteDao = new UtenteDao();
    CarrelloDao carrelloDao = new CarrelloDao();

    @Override
    public void init() throws ServletException {
        this.utenteDao = new UtenteDao();
        this.carrelloDao = new CarrelloDao();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/register.jsp").forward(request, response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utente utente =  new Utente();

        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String numero = request.getParameter("numero");
        String indirizzo = request.getParameter("indirizzo");
        String password = request.getParameter("password");
        String passwordconf = request.getParameter("passwordconf");
        try {
            password = Password.getHash(password);
            passwordconf = Password.getHash(passwordconf);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

       if (password.equals(passwordconf)) {

           utente.setNome(nome);
           utente.setCognome(cognome);
           utente.setEmail(email);
           utente.setNumero(numero);
           utente.setIndirizzo(indirizzo);
           utente.setPassword(password);

           if ( utenteDao.register(utente)){
               response.sendRedirect(request.getContextPath() + "/login");
           }

       } else {

           request.setAttribute("errore", "Password non coincidenti.");
           request.getRequestDispatcher("/register.jsp").forward(request, response);

       }


    }


}
