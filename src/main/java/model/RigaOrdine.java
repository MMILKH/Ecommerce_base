package model;

public class RigaOrdine {
    private int id;
    private int ordineId;
    private int prodottoId;
    private String sku;
    private String nomeProdotto;
    private int quantita;
    private double prezzoUnitario;
    private double prezzoRiga;

    public RigaOrdine() {
    }

    public RigaOrdine(int id, int ordineId, int prodottoId, String sku, String nomeProdotto, int quantita, double prezzoUnitario, double prezzoRiga) {
        this.id = id;
        this.ordineId = ordineId;
        this.prodottoId = prodottoId;
        this.sku = sku;
        this.nomeProdotto = nomeProdotto;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
        this.prezzoRiga = prezzoRiga;
    }

    public RigaOrdine(int ordineId, int prodottoId, int quantita, double prezzoUnitario, double prezzoRiga) {
        this.ordineId = ordineId;
        this.prodottoId = prodottoId;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
        this.prezzoRiga = prezzoRiga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdineId() {
        return ordineId;
    }

    public void setOrdineId(int ordineId) {
        this.ordineId = ordineId;
    }

    public int getProdottoId() {
        return prodottoId;
    }

    public void setProdottoId(int prodottoId) {
        this.prodottoId = prodottoId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzoUnitario(double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    public double getPrezzoRiga() {
        return prezzoRiga;
    }

    public void setPrezzoRiga(double prezzoRiga) {
        this.prezzoRiga = prezzoRiga;
    }

    @Override
    public String toString() {
        return "RigaOrdine{" +
                "id=" + id +
                ", ordineId=" + ordineId +
                ", prodottoId=" + prodottoId +
                ", sku='" + sku + '\'' +
                ", nomeProdotto='" + nomeProdotto + '\'' +
                ", quantita=" + quantita +
                ", prezzoUnitario=" + prezzoUnitario +
                ", prezzoRiga=" + prezzoRiga +
                '}';
    }
}
