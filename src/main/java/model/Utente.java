package model;

import java.util.Date;

public class Utente {
    private int id;
    Ruolo ruolo;
    private String nome, cognome, email, numero, indirizzo, password;
    private Date data_creazione;
    private Date data_ultima_modifica;

    public Utente(int id, String nome, String cognome, String email, String numero, String indirizzo, Ruolo ruolo, String password, Date data_creazione, Date data_ultima_modifica) {
        this.id = id;
        this.ruolo = ruolo;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numero = numero;
        this.indirizzo = indirizzo;
        this.password = password;
        this.data_creazione = data_creazione;
        this.data_ultima_modifica = data_ultima_modifica;
    }

    public Utente() {
    }

    public Utente(Ruolo ruolo, String nome, String cognome, String email, String numero, String indirizzo, String password, Date data_creazione, Date data_ultima_modifica) {

        this.ruolo = ruolo;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numero = numero;
        this.indirizzo = indirizzo;
        this.password = password;
        this.data_creazione = data_creazione;
        this.data_ultima_modifica = data_ultima_modifica;

    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
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

    public Date getData_creazione() {
        return data_creazione;
    }

    public void setData_creazione(Date data_creazione) {
        this.data_creazione = data_creazione;
    }

    public Date getData_ultima_modifica() {
        return data_ultima_modifica;
    }

    public void setData_ultima_modifica(Date data_ultima_modifica) {
        this.data_ultima_modifica = data_ultima_modifica;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", ruolo=" + ruolo +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", numero='" + numero + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", password='" + password + '\'' +
                ", data_creazione='" + data_creazione + '\'' +
                ", data_ultima_modifica='" + data_ultima_modifica + '\'' +
                '}';
    }
}
