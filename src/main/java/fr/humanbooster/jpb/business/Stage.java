package fr.humanbooster.jpb.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Stage {

    //Attributs
    private Date date;
    private Code code;
    private List<String> activites = new ArrayList<>();
    private int prix;

    //Constructeurs
    public Stage() {
        super();
    }
    public Stage(Code code){
        this();
        setCode(code);
    }
    public Stage(Date date) {
        this.date = date;
    }
    public Stage(Date date, Code code, List<String> activites, int prix) {
        this.date = date;
        this.code = code;
        this.activites = activites;
        this.prix = prix;
    }
    //Getter & Setter
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public List<String> getActivites() {
        return activites;
    }

    public void setActivites(List<String> activites) {
        this.activites = activites;
    }
    public void addActivites(String activite) {
        activites.add(activite);
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    //toString
    @Override
    public String toString() {
        return "Stage{" +
                "date=" + date +
                ", code=" + code +
                ", activites=" + activites +
                ", prix=" + prix +
                '}';
    }
}
