package fr.humanbooster.jpb.business;

public class Cavalier {

    //Attribut
    String nom;

    //Constructeur
    public Cavalier(String nom) {
        this.nom = nom;
    }
    //Getter & Setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    //toString
    @Override
    public String toString() {
        return "Cavalier{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
