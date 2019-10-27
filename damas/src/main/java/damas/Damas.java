package damas;

import damas.controllers.Controller;
import damas.controllers.Logic;
import damas.views.ConsoleView;
import damas.views.View;

public class Damas {
    private Logic logic;
    private View view;

    private Damas() {
        this.logic = new Logic();
        this.view = new ConsoleView();
    }

    public static void main(String[] args) {
        new Damas().play();
    }

    public void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null)
                this.view.interact(controller);
        } while (controller != null);
    }
}