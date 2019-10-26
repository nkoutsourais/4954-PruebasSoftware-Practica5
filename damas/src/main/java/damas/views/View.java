package damas.views;

import damas.controllers.*;

public interface View extends AcceptController {
    void interact(Controller controller);
}