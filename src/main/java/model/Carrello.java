package model;


import java.util.Date;

public class Carrello {
    private int id;
    private Utente utente;
    private Date dataCreazione;
    private Date ultimoAggiornamento;


    public Carrello() {
    }


    public Carrello(int id, Utente utente, Date dataCreazione, Date ultimoAggiornamento) {
        this.id = id;
        this.utente = new Utente();
        this.dataCreazione = dataCreazione;
        this.ultimoAggiornamento = ultimoAggiornamento;
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

// public Carrello(int utenteId) {

//  this.utenteId = utenteId;

//  }


