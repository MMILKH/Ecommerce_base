package model;


public class Carrello {
    private int id;
    private Utente utente;
    private String dataCreazione;
    private String ultimoAggiornamento;


    public Carrello() {
    }


    public Carrello(int id, Utente utente, String dataCreazione, String ultimoAggiornamento) {
        this.id = id;
        this.utente = new Utente();
        this.dataCreazione = dataCreazione;
        this.ultimoAggiornamento = ultimoAggiornamento;
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

    public String getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(String dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public String getUltimoAggiornamento() {
        return ultimoAggiornamento;
    }

    public void setUltimoAggiornamento(String ultimoAggiornamento) {
        this.ultimoAggiornamento = ultimoAggiornamento;
    }

    @Override
    public String toString() {
        return "Carrello{" +
                "id=" + id +
                ", utente=" + utente +
                ", dataCreazione='" + dataCreazione + '\'' +
                ", ultimoAggiornamento='" + ultimoAggiornamento + '\'' +
                '}';
    }
}

   // public Carrello(int utenteId) {

      //  this.utenteId = utenteId;

  //  }


