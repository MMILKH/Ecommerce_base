package model;

import java.time.LocalDateTime;

public class RigaCarrello {
    private int id;
    private Carrello carrello;
    private Prodotto prodotto;
    private int quantita;
    private LocalDateTime dataCreazione;


    public RigaCarrello() {
    }


    public RigaCarrello(int id, Carrello carrello, Prodotto prodotto, int quantita, LocalDateTime dataCreazione) {
        this.id = id;
        this.carrello = carrello;
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.dataCreazione = dataCreazione;
    }


    public RigaCarrello(Carrello carrello, Prodotto prodotto, int quantita, LocalDateTime dataCreazione) {
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

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }
}