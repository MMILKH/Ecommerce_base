package model;

public class Stato {

    private int id;
    private String nome;
    private String descrizione;
    private String codice;
    public Stato() {
    }

    public Stato(String nome, String descrizione, String codice) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.codice = codice;
    }

    public Stato(int id, String nome, String descrizione,String codice) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.codice = codice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    @Override
    public String toString() {
        return "Stato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", codice='" + codice + '\'' +
                '}';
    }


}
