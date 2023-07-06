package fr.humanbooster.jpb.business;

import java.util.Date;

public abstract class StageDecorator extends Stage {
    protected Stage stage;
    public StageDecorator(Stage stage) {
        super();
        this.stage = stage;
    }
}
