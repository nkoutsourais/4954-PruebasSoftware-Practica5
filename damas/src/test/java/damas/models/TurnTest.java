package damas.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TurnTest {

    @Test
    public void givenTurnWhenChangeTurnThenNoErrorColor() {
        Turn turn = new Turn();
        assertEquals(Color.WHITE, turn.getColor());
        turn.next();
        assertEquals(Color.BLACK, turn.getColor());
        turn.next();
        assertEquals(Color.WHITE, turn.getColor());
    }
}