package fr.humanbooster.jpb.builder;

import fr.humanbooster.jpb.business.Poney;

import java.util.List;

public interface PoneyBuilder {

    List<Poney> getPoneys();
    PoneyBuilder ajouterNom(String nom);
    PoneyBuilder ajouterCouvreReins(String couvreReins);
    PoneyBuilder ajouterSelle(String selle);
    PoneyBuilder ajouterBride(String bride);
    PoneyBuilder ajouterRenes(String renes);
    Poney build();
}
