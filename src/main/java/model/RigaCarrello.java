package model;

public class RigaCarrello {
    private int id;
    private int carrelloId;
    private int prodottoId;
    private int quantita;
    private String dataCreazione;

    // Costruttore vuoto (JavaBean)
    public RigaCarrello() {}

    // Costruttore completo (per letture da DB)
    public RigaCarrello(int id, int carrelloId, int prodottoId, int quantita, String dataCreazione) {
        this.id = id;
        this.carrelloId = carrelloId;
        this.prodottoId = prodottoId;
        this.quantita = quantita;
        this.dataCreazione = dataCreazione;
    }

    // Costruttore per inserimento nel carrello
    public RigaCarrello(int carrelloId, int prodottoId, int quantita) {
        this.carrelloId = carrelloId;
        this.prodottoId = prodottoId;
        this.quantita = quantita;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarrelloId() {
        return carrelloId;
    }

    public void setCarrelloId(int carrelloId) {
        this.carrelloId = carrelloId;
    }

    public int getProdottoId() {
        return prodottoId;
    }

    public void setProdottoId(int prodottoId) {
        this.prodottoId = prodottoId;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(String dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    @Override
    public String toString() {
        return "RigaCarrello{" +
                "id=" + id +
                ", carrelloId=" + carrelloId +
                ", prodottoId=" + prodottoId +
                ", quantita=" + quantita +
                ", dataCreazione='" + dataCreazione + '\'' +
                '}';
    }
}