package model;


import java.util.Date;

public class Carrello {
    private int id;
    private Utente utente;
    private Date dataCreazione;
    private Date ultimoAggiornamento;
    private String stato;


    public Carrello() {
    }


    public Carrello(int id, Utente utente, Date dataCreazione, Date ultimoAggiornamento, String stato) {
        this.id = id;
        this.utente = new Utente();
        this.dataCreazione = dataCreazione;
        this.ultimoAggiornamento = ultimoAggiornamento;
        this.stato = stato;
    }

    public Carrello(Utente utente, Date dataCreazione, Date ultimoAggiornamento, String stato) {
        this.utente = new Utente();
        this.dataCreazione = dataCreazione;
        this.ultimoAggiornamento = ultimoAggiornamento;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Date getUltimoAggiornamento() {
        return ultimoAggiornamento;
    }

    public void setUltimoAggiornamento(Date ultimoAggiornamento) {
        this.ultimoAggiornamento = ultimoAggiornamento;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Carrello{" +
                "id=" + id +
                ", utente=" + utente +
                ", dataCreazione='" + dataCreazione + '\'' +
                ", ultimoAggiornamento='" + ultimoAggiornamento + '\'' +
                '}';
    }
}




