package sample;

public class Game {

    private Field field;
    private State state;

    public Game() {
        field = new Field();
        state = State.READY;
    }

    public void startGame() {
        if (state == State.READY) {
            state = State.RUNNING;
        }
        field.shuffle();
    }

    public void endGame() {
        if (state == State.RUNNING) {
            state = State.GAME_OVER;
            //field = null;  // unable to rewrite the new field if it's has a null in it
        }
    }

    public void resetGame() {
        if (state != State.READY) {
            state = State.READY;
            //field = null;
        }
    }

    public void nextMove(int code) {
        if (state == State.RUNNING)
            field.toggleTiled(code);
        field.print();
        if (field.isWinner()) {
            System.out.println("You won!");
            endGame();
        }
    }

    public Field getField() {
        return field;
    }
}
