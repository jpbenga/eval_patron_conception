package fr.humanbooster.jpb.business;

public class SautObstacle extends StageDecorator{

    private static final int PRIX = 40;

    public SautObstacle(Stage stage) {
        super(stage);
        super.addActivites(" Saut d'obstacles");
        super.setPrix(getPrix() + PRIX);
    }
}
