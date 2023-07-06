package fr.humanbooster.jpb.business;

public class PonyGames extends StageDecorator{

    private static final int PRIX = 20;
    public PonyGames(Stage stage) {
        super(stage);
        super.addActivites(" Pony Games");
        super.setPrix(getPrix() + PRIX);
    }
}
