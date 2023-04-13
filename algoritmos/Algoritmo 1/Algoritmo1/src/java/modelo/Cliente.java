package modelo;

/**
 *
 * @author fabio
 */

public class Cliente {
    
    int idCliente;
    String nomeCliente;

    public Cliente() {  }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}