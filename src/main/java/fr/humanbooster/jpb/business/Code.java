package fr.humanbooster.jpb.business;

public class Code {

    private String numero;

    public Code(String numero) {
        this.setNumero(numero);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Numéro de séjour [numero=" + numero + "]";
    }
}
