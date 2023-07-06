package fr.humanbooster.jpb.business;

import fr.humanbooster.jpb.iterator.CollectionDePoneys;

public class Poney {

    // Attributs
    private String nom;
    private String couvreReins;
    private String selle;
    private String bride;
    private String renes;

    // Constructeurs
    public Poney() {
        super();
    }

    public Poney(String nom) {
        this.nom = nom;
    }

    public Poney(String nom, String couvreReins, String selle, String bride, String renes) {
        this.nom = nom;
        this.couvreReins = couvreReins;
        this.selle = selle;
        this.bride = bride;
        this.renes = renes;
    }

    // Getter & Setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCouvreReins() {
        return couvreReins;
    }

    public void setCouvreReins(String couvreReins) {
        this.couvreReins = couvreReins;
    }

    public String getSelle() {
        return selle;
    }

    public void setSelle(String selle) {
        this.selle = selle;
    }

    public String getBride() {
        return bride;
    }

    public void setBride(String bride) {
        this.bride = bride;
    }

    public String getRenes() {
        return renes;
    }

    public void setRenes(String renes) {
        this.renes = renes;
    }

    // toString
    @Override
    public String toString() {
        return "Poney{" +
                "nom='" + nom + '\'' +
                ", couvreReins='" + couvreReins + '\'' +
                ", selle='" + selle + '\'' +
                ", bride='" + bride + '\'' +
                ", renes='" + renes + '\'' +
                '}';
    }
}
