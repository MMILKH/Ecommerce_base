//package controller;
//
//
//import dao.*;
//import model.*;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@WebServlet("/ordine")
//public class OridineServet extends HttpServlet {
//
//    CarrelloDao carrelloDao;
//    ProdottoDao prodottoDao;
//    RigaCarrelloDao rigaCarrelloDao;
//    OrdineDao ordineDao;
//    RigaOrdineDao rigaOrdineDao;
//
//    @Override
//    public void init() {
//        carrelloDao = new CarrelloDao();
//        prodottoDao = new ProdottoDao();
//        rigaCarrelloDao = new RigaCarrelloDao();
//        ordineDao = new OrdineDao();
//        rigaOrdineDao = new RigaOrdineDao();
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//        response.setDateHeader("Expires", 0);
//        HttpSession session = request.getSession();
//        Utente u = null;
//        if (session == null || session.getAttribute("utenteLoggato") == null) {
//            response.sendRedirect(request.getContextPath() + "/login");
//        } else {
//            u = (Utente) session.getAttribute("utenteLoggato");
//        }
//
//        double totale = 0;
//
//        Carrello c = carrelloDao.findByUtenteId(u.getId());
//        List<RigaOrdine> righe = rigaOrdineDao.findByOrdineId(c.getId());
//        List<Prodotto> prodotti = new ArrayList<>();
//        Map<Integer, Integer> quantitaxprodotto = new HashMap<>();
//        for (RigaOrdine r : righe) {
//
//            quantitaxprodotto.put((Integer) r.getProdottoId(), (Integer) r.getQuantita());
//            Prodotto p = prodottoDao.findById(r.getProdottoId());
//            prodotti.add(p);
//
//            totale += r.getPrezzoRiga();
//
//        }
//        request.setAttribute("listaProdotti", prodotti);
//        request.setAttribute("listaQuantita", quantitaxprodotto);
//        request.setAttribute("listaRighe", righe);
//        request.setAttribute("totale", totale);
//
//        request.getRequestDispatcher("/ordine.jsp").forward(request, response);
//
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        HttpSession session = request.getSession();
//        Utente u = null;
//        double totale = 0;
//        Ordine ordine = null;
//
//        if (session == null || session.getAttribute("utenteLoggato") == null) {
//            response.sendRedirect(request.getContextPath() + "/login");
//        } else {
//            u = (Utente) session.getAttribute("utenteLoggato");
//        }
//
//        Carrello c = carrelloDao.findByUtenteId(u.getId());
//        List<RigaCarrello> righe = rigaCarrelloDao.findByCarrelloId(c.getId());
//        List<Prodotto> prodotti = new ArrayList<>();
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (RigaCarrello r : righe) {
//            Prodotto p = prodottoDao.findById(r.getProdottoId());
//            prodotti.add(p);
//            map.put((Integer) p.getId(), (Integer) r.getQuantita());
//            totale += p.getPrezzo() * r.getQuantita();
//        }
//
//        ordine = new Ordine(u.getId(), 1, totale, request.getParameter("indirizzoS"), "");
//        ordineDao.save(ordine);
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            Prodotto p = prodottoDao.findById(entry.getKey());
//            int qta = entry.getValue();
//            RigaOrdine r = new RigaOrdine(ordine.getId(), p.getId(), qta, p.getPrezzo(), p.getPrezzo() * qta);
//            rigaOrdineDao.save(r);
//        }
//
//
//        response.sendRedirect(request.getContextPath() + "/ordine");
//
//
//    }
//
//}
//
