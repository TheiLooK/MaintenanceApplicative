package trivia;

import java.util.*;

public class Game implements IGame {
   private static final int MAX_POSITIONS = 12;
   private static final int WINNING_SCORE = 6;

   private final List<Player> players = new ArrayList<>();
   private final QuestionDeck questionDeck = new QuestionDeck();

   private int currentPlayerIndex = 0;

   public boolean add(String playerName) {
      players.add(new Player(playerName));
      System.out.println(playerName + " was added");
      System.out.println("They are player number " + players.size());
      return true;
   }

   public void roll(int roll) {
      Player currentPlayer = players.get(currentPlayerIndex);
      System.out.println(currentPlayer.getName() + " is the current player");
      System.out.println("They have rolled a " + roll);

      if (currentPlayer.isInPenaltyBox()) {
         boolean isGettingOutOfPenaltyBox = roll % 2 != 0;
         if (isGettingOutOfPenaltyBox) {
            players.get(currentPlayerIndex).getOutOfPenaltyBox();
            System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
         } else {
            System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
            return;
         }
      }

      currentPlayer.move(roll, MAX_POSITIONS);
      System.out.println(currentPlayer.getName() + "'s new location is " + currentPlayer.getPosition());
      System.out.println("The category is " + questionDeck.getCategory(currentPlayer.getPosition()));
      askQuestion();
   }

   private void askQuestion() {
      String category = questionDeck.getCategory(players.get(currentPlayerIndex).getPosition());
      System.out.println(questionDeck.askQuestion(category));
   }

   public boolean handleCorrectAnswer() {
      Player currentPlayer = players.get(currentPlayerIndex);

      if (!currentPlayer.isInPenaltyBox()) {
         System.out.println("Answer was correct!!!!");
         currentPlayer.addCoin();
         System.out.println(currentPlayer.getName() + " now has " + currentPlayer.getCoins() + " Gold Coins.");

         if (currentPlayer.getCoins() == WINNING_SCORE) {
            return false; // Game over condition
         }
      }

      nextPlayer();
      return true;
   }

   public boolean handleWrongAnswer() {
      Player currentPlayer = players.get(currentPlayerIndex);
      System.out.println("Question was incorrectly answered");
      System.out.println(currentPlayer.getName() + " was sent to the penalty box");
      currentPlayer.sendToPenaltyBox();

      nextPlayer();
      return true;
   }

   private void nextPlayer() {
      currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
   }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
