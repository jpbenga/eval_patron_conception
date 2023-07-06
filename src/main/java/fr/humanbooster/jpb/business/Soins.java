package fr.humanbooster.jpb.business;

public class Soins extends StageDecorator{

    private static final int PRIX = 25;

    public Soins(Stage stage) {
        super(stage);
        super.addActivites(" Soins");
        super.setPrix(getPrix() + PRIX);
    }
}
