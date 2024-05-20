package pong;

public class GameState {
    public static GameState instance;
    private int p1Score;
    private int p2Score;

    private GameState() {
    }

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public int getP1Score() {
        return p1Score;
    }

    public void upP1Score() {
        this.p1Score += 1;
    }

    public int getP2Score() {
        return p2Score;
    }

    public void upP2Score() {
        this.p2Score += 1;
    }

    public void newGame() {
        p1Score = 0;
        p2Score = 0;
    }
}
