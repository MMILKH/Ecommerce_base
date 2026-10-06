package model;

import java.util.Date;

public class RigaCarrello {
    private int id;
    private Carrello carrello;
    private Prodotto prodotto;
    private int quantita;
    private Date dataCreazione;
    private Date ultimaModifica;


    public RigaCarrello() {
    }


    public RigaCarrello(int id, Carrello carrello, Prodotto prodotto, int quantita, Date dataCreazione, Date ultimaModifica) {
        this.id = id;
        this.carrello = carrello;
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.dataCreazione = dataCreazione;
        this.ultimaModifica = ultimaModifica;
    }


    public RigaCarrello(Carrello carrello, Prodotto prodotto, int quantita, Date dataCreazione, Date ultimaModifica) {
        this.carrello = carrello;
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.dataCreazione = dataCreazione;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Date getUltimaModifica() {
        return ultimaModifica;
    }

    public void setUltimaModifica(Date ultimaModifica) {
        this.ultimaModifica = ultimaModifica;
    }

    @Override
    public String toString() {
        return "RigaCarrello{" +
                "id=" + id +
                ", carrello=" + carrello +
                ", prodotto=" + prodotto +
                ", quantita=" + quantita +
                ", dataCreazione=" + dataCreazione +
                ", ultimaModifica=" + ultimaModifica +
                '}';
    }
}