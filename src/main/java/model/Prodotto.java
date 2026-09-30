package model;

public class Prodotto {
    private int id;
    private String sku;
    private String nome;
    private String descrizioneBreve;
    private String descrizioneEstesa;
    private double prezzo;
    private String immagine;
    private String categoria;
    private int disponibilita;
    private int statoPub;


    public Prodotto() {}


    public Prodotto(int id, String sku, String nome, String descrizioneBreve,
                    String descrizioneEstesa, double prezzo, String immagine,
                    String categoria, int disponibilita, int statoPub) {
        this.id = id;
        this.sku = sku;
        this.nome = nome;
        this.descrizioneBreve = descrizioneBreve;
        this.descrizioneEstesa = descrizioneEstesa;
        this.prezzo = prezzo;
        this.immagine = immagine;
        this.categoria = categoria;
        this.disponibilita = disponibilita;
        this.statoPub = statoPub;
    }


    public Prodotto(String sku, String nome, String descrizioneBreve,
                    String descrizioneEstesa, double prezzo, String immagine,
                    String categoria, int disponibilita, int statoPub) {
        this.sku = sku;
        this.nome = nome;
        this.descrizioneBreve = descrizioneBreve;
        this.descrizioneEstesa = descrizioneEstesa;
        this.prezzo = prezzo;
        this.immagine = immagine;
        this.categoria = categoria;
        this.disponibilita = disponibilita;
        this.statoPub = statoPub;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizioneBreve() {
        return descrizioneBreve;
    }

    public void setDescrizioneBreve(String descrizioneBreve) {
        this.descrizioneBreve = descrizioneBreve;
    }

    public String getDescrizioneEstesa() {
        return descrizioneEstesa;
    }

    public void setDescrizioneEstesa(String descrizioneEstesa) {
        this.descrizioneEstesa = descrizioneEstesa;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public int getStatoPub() {
        return statoPub;
    }

    public void setStatoPub(int statoPub) {
        this.statoPub = statoPub;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", disponibilita=" + disponibilita +
                ", statoPub=" + statoPub +
                '}';
    }
}
