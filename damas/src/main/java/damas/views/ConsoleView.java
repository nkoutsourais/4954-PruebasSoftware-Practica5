package damas.views;

import damas.controllers.Controller;
import damas.controllers.PlayController;
import damas.controllers.ResumeController;
import damas.controllers.StartController;

public class ConsoleView implements View {

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
    }

    @Override
    public void visit(PlayController proposeCombinationController) {
    }

    @Override
    public void visit(ResumeController resumeController) {
    }
}