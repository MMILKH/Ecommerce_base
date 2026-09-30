package model;

import javax.print.DocFlavor;

public class Utente {
    private int id, ruoloId;
    private String nome, cognome, email,numero, indirizzo, password,data_creazione, data_ultima_creazione;

    public Utente(int id, String nome, String cognome, String email, String numero, String indirizzo,int ruoloId, String password, String data_creazione, String data_ultima_creazione) {
        this.id = id;
        this.ruoloId = ruoloId;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numero = numero;
        this.indirizzo = indirizzo;
        this.password = password;
        this.data_creazione = data_creazione;
        this.data_ultima_creazione = data_ultima_creazione;
    }
    public Utente(){}

    public Utente( int ruoloId, String nome, String cognome, String email, String numero, String indirizzo, String password, String data_creazione, String data_ultima_creazione) {

        this.ruoloId = ruoloId;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numero = numero;
        this.indirizzo = indirizzo;
        this.password = password;
        this.data_creazione = data_creazione;
        this.data_ultima_creazione = data_ultima_creazione;

    }

    public int getRuoloId() {
        return ruoloId;
    }

    public void setRuoloId(int ruoloId) {
        this.ruoloId = ruoloId;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getData_creazione() {
        return data_creazione;
    }

    public void setData_creazione(String data_creazione) {
        this.data_creazione = data_creazione;
    }

    public String getData_ultima_creazione() {
        return data_ultima_creazione;
    }

    public void setData_ultima_creazione(String data_ultima_creazione) {
        this.data_ultima_creazione = data_ultima_creazione;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", ruoloId=" + ruoloId +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", numero='" + numero + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", password='" + password + '\'' +
                ", data_creazione='" + data_creazione + '\'' +
                ", data_ultima_creazione='" + data_ultima_creazione + '\'' +
                '}';
    }
}
