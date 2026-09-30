package model;

public class Ordine {
    private int id;
    private int utenteId;
    private int statoId;
    private double importoTotale;
    private String indirizzoSpedizione;
    private String dataCreazione;

    public Ordine() {}

    public Ordine(int id, int utenteId, int statoId, double importoTotale, String indirizzoSpedizione, String dataCreazione) {
        this.id = id;
        this.utenteId = utenteId;
        this.statoId = statoId;
        this.importoTotale = importoTotale;
        this.indirizzoSpedizione = indirizzoSpedizione;
        this.dataCreazione = dataCreazione;
    }

    public Ordine(int utenteId, int statoId, double importoTotale, String indirizzoSpedizione,String dataCreazione) {
        this.utenteId = utenteId;
        this.statoId = statoId;
        this.importoTotale = importoTotale;
        this.indirizzoSpedizione = indirizzoSpedizione;
        this.dataCreazione = dataCreazione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUtenteId() {
        return utenteId;
    }

    public void setUtenteId(int utenteId) {
        this.utenteId = utenteId;
    }

    public int getStato() {
        return statoId;
    }

    public void setStato(int statoId) {
        this.statoId = statoId;
    }

    public double getImportoTotale() {
        return importoTotale;
    }

    public void setImportoTotale(double importoTotale) {
        this.importoTotale = importoTotale;
    }

    public String getIndirizzoSpedizione() {
        return indirizzoSpedizione;
    }

    public void setIndirizzoSpedizione(String indirizzoSpedizione) {
        this.indirizzoSpedizione = indirizzoSpedizione;
    }

    public String getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(String dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", utenteId=" + utenteId +
                ", statoId='" + statoId + '\'' +
                ", importoTotale=" + importoTotale +
                ", indirizzoSpedizione='" + indirizzoSpedizione + '\'' +
                ", dataCreazione='" + dataCreazione + '\'' +
                '}';
    }
}
