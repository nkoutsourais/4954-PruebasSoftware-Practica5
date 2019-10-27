package damas.controllers;

import damas.models.State;

public class CancelController {

    private final State state;

    public CancelController(State state) {
        this.state = state;
    }

    public void cancel() {
        this.state.next();
    }
}