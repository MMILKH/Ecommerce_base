package model;


import java.math.BigDecimal;
import java.util.Date;


public class Ordine {

    private int id;
    private Utente utente;
    private String codice;
    private Stato stato;
    private BigDecimal importoTotale;
    private String indirizzoSpedizione;
    private String indirizzoFatturazione;
    private Date dataCreazione;

    public Ordine() {
    }

    public Ordine(int id, Utente utente, Stato stato, BigDecimal importoTotale, String indirizzoFatturazione, String indirizzoSpedizione, Date dataCreazione, String codice) {
        this.id = id;
        this.utente = utente;
        this.stato = stato;
        this.importoTotale = importoTotale;
        this.indirizzoFatturazione = indirizzoFatturazione;
        this.indirizzoSpedizione = indirizzoSpedizione;
        this.dataCreazione = dataCreazione;
        this.codice = codice;
    }

    public Ordine(Utente utente, BigDecimal importoTotale, Stato stato, String indirizzoSpedizione, String indirizzoFatturazione, Date dataCreazione, String codice) {
        this.utente = utente;
        this.importoTotale = importoTotale;
        this.stato = stato;
        this.indirizzoSpedizione = indirizzoSpedizione;
        this.indirizzoFatturazione = indirizzoFatturazione;
        this.dataCreazione = dataCreazione;
        this.codice = codice;
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

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public BigDecimal getImportoTotale() {
        return importoTotale;
    }

    public void setImportoTotale(BigDecimal importoTotale) {
        this.importoTotale = importoTotale;
    }

    public String getIndirizzoSpedizione() {
        return indirizzoSpedizione;
    }

    public void setIndirizzoSpedizione(String indirizzoSpedizione) {
        this.indirizzoSpedizione = indirizzoSpedizione;
    }

    public String getIndirizzoFatturazione() {
        return indirizzoFatturazione;
    }

    public void setIndirizzoFatturazione(String indirizzoFatturazione) {
        this.indirizzoFatturazione = indirizzoFatturazione;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public String getCodice() {
        return codice;

    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", utente=" + utente +
                ", codice=" + codice +
                ", stato=" + stato +
                ", importoTotale=" + importoTotale +
                ", indirizzoSpedizione='" + indirizzoSpedizione + '\'' +
                ", indirizzoFatturazione='" + indirizzoFatturazione + '\'' +
                ", dataCreazione=" + dataCreazione +
                '}';
    }
}
