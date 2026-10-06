package model;

import java.util.Date;

public class RigaOrdine {
    private int id;
    private Ordine ordine;
    private Prodotto prodotto;
    private int quantita;
    private double prezzoRiga;
    private double prezzoUnitario;
    private int rigaCarrelloId;
    private Date dataCreazione;

    public RigaOrdine() {
    }

    public RigaOrdine(int id, Ordine ordine, Prodotto prodotto, int quantita, double prezzoRiga, int rigaCarrelloId, Date dataCreazione, double prezzoUnitario) {
        this.id = id;
        this.ordine = ordine;
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.prezzoRiga = prezzoRiga;
        this.rigaCarrelloId = rigaCarrelloId;
        this.dataCreazione = dataCreazione;
        this.prezzoUnitario = prezzoUnitario;
    }

    public RigaOrdine(Ordine ordine, Prodotto prodotto, int quantita, double prezzoRiga, int rigaCarrelloId, Date dataCreazione, double prezzoUnitario) {
        this.ordine = ordine;
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.prezzoRiga = prezzoRiga;
        this.rigaCarrelloId = rigaCarrelloId;
        this.dataCreazione = dataCreazione;
        this.prezzoUnitario = prezzoUnitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
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

    public double getPrezzoRiga() {
        return prezzoRiga;
    }

    public void setPrezzoRiga(double prezzoRiga) {
        this.prezzoRiga = prezzoRiga;
    }

    public int getRigaCarrelloId() {
        return rigaCarrelloId;
    }

    public void setRigaCarrelloId(int rigaCarrelloId) {
        this.rigaCarrelloId = rigaCarrelloId;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzoUnitario(double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    @Override
    public String toString() {
        return "RigaOrdine{" +
                "id=" + id +
                ", ordine=" + ordine +
                ", prodotto=" + prodotto +
                ", quantita=" + quantita +
                ", prezzoRiga=" + prezzoRiga +
                ", prezzoUnitario=" + prezzoUnitario +
                ", rigaCarrelloId=" + rigaCarrelloId +
                ", dataCreazione=" + dataCreazione +
                '}';
    }
}
