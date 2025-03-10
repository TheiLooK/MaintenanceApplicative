package trivia;

import java.util.*;

public class QuestionDeck {
    private final Map<String, Queue<String>> questions = new HashMap<>();

    public QuestionDeck() {
        questions.put("Pop", createQuestions("Pop"));
        questions.put("Science", createQuestions("Science"));
        questions.put("Sports", createQuestions("Sports"));
        questions.put("Rock", createQuestions("Rock"));
    }

    private Queue<String> createQuestions(String category) {
        Queue<String> questionQueue = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            questionQueue.add(category + " Question " + i);
        }
        return questionQueue;
    }

    public String getCategory(int position) {
        return switch ((position - 1) % 4) {
            case 0 -> "Pop";
            case 1 -> "Science";
            case 2 -> "Sports";
            default -> "Rock";
        };
    }

    public String askQuestion(String category) {
        return questions.get(category).poll();
    }
}
