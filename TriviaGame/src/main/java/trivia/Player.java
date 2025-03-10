package trivia;

public class Player {
    private final String name;
    private int position = 1;
    private int coins = 0;
    private boolean inPenaltyBox = false;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getCoins() {
        return coins;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void move(int roll, int maxPlaces) {
        position = (position + roll) % maxPlaces;
        if (position == 0) {
            position = maxPlaces; // Faire en sorte que le joueur ne revienne pas à 0
        }
    }


    public void addCoin() {
        coins++;
    }

    public void sendToPenaltyBox() {
        inPenaltyBox = true;
    }

    public void getOutOfPenaltyBox() {
        inPenaltyBox = false;
    }
}
