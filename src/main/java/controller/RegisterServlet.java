package controller;

import dao.CarrelloDao;
import dao.RuoloDao;
import dao.UtenteDao;
import model.Carrello;
import model.Utente;
import util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {


    UtenteDao utenteDao = new UtenteDao();
    CarrelloDao carrelloDao = new CarrelloDao();
    RuoloDao ruoloDao = new RuoloDao();

    @Override
    public void init() throws ServletException {
        this.utenteDao = new UtenteDao();
        this.carrelloDao = new CarrelloDao();
        this.ruoloDao = new RuoloDao();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/register.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utente utente = new Utente();
        Utente temp = null;
        int id = 0;
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
            utente.setRuolo(ruoloDao.findByNome("customer"));
            id = utenteDao.save(utente);
            if (id != 0) {
                Carrello carrello = new Carrello();
                temp = utenteDao.findById(id);
                carrello.setUtente(temp);
                carrello.setDataCreazione(new java.util.Date());
                carrello.setUltimoAggiornamento(new java.util.Date());
                carrello.setStato("NEW");
                carrelloDao.save(carrello);

                response.sendRedirect(request.getContextPath() + "/login");

            }

        } else {

            request.setAttribute("errore", "Password non coincidenti.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);

        }


    }


}
