package fr.humanbooster.jpb.business;

public class Balade extends StageDecorator{

    private static final int PRIX = 35;
    public Balade(Stage stage) {
        super(stage);
        super.addActivites(" Balade");
        super.setPrix(getPrix() + PRIX);
    }
}
