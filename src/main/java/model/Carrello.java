package model;


public class Carrello {
    private int id;
    private int utenteId;
    private String dataCreazione;
    private String ultimoAggiornamento;


    public Carrello() {}


    public Carrello(int id, int utenteId, String dataCreazione, String ultimoAggiornamento) {
        this.id = id;
        this.utenteId = utenteId;
        this.dataCreazione = dataCreazione;
        this.ultimoAggiornamento = ultimoAggiornamento;
    }


    public Carrello(int utenteId) {
        this.utenteId = utenteId;
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
                ", utenteId=" + utenteId +
                ", dataCreazione='" + dataCreazione + '\'' +
                ", ultimoAggiornamento='" + ultimoAggiornamento + '\'' +
                '}';
    }


}
