package fr.humanbooster.jpb.builder.impl;

import fr.humanbooster.jpb.business.Poney;
import fr.humanbooster.jpb.builder.PoneyBuilder;

import java.util.ArrayList;
import java.util.List;

public class PoneyBuilderImpl implements PoneyBuilder {

    private List<Poney> poneys = new ArrayList<>();
    private Poney poney;

    public PoneyBuilderImpl() {
        Poney ribambelle = new Poney("Ribambelle");
        Poney ping = new Poney("Ping");
        Poney pong = new Poney("Pong");
        Poney impala = new Poney("Impala");
        Poney bueno = new Poney("Bueno");
        Poney country = new Poney("Country");
        Poney forza = new Poney("Forza");
        Poney horizon = new Poney("Horizon");
        Poney cassandra = new Poney("Cassandra");
        Poney oasis = new Poney("Oasis");

        poneys.add(ribambelle);
        poneys.add(ping);
        poneys.add(pong);
        poneys.add(impala);
        poneys.add(bueno);
        poneys.add(country);
        poneys.add(forza);
        poneys.add(horizon);
        poneys.add(cassandra);
        poneys.add(oasis);
    }

    public PoneyBuilder ajouterNom(String nom) {
        poney = new Poney(nom);
        return this;
    }

    public PoneyBuilder ajouterCouvreReins(String couvreReins) {
        poney.setCouvreReins(couvreReins);
        return this;
    }

    public PoneyBuilder ajouterSelle(String selle) {
        poney.setSelle(selle);
        return this;
    }

    public PoneyBuilder ajouterBride(String bride) {
        poney.setBride(bride);
        return this;
    }

    public PoneyBuilder ajouterRenes(String renes) {
        poney.setRenes(renes);
        return this;
    }

    public Poney build() {
        poneys.add(poney);
        return poney;
    }

    public List<Poney> getPoneys() {
        return poneys;
    }
}
