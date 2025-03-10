package trivia;

import java.util.*;

import static trivia.Const.*;

public class QuestionDeck {
    private final Map<String, Queue<String>> questions = new HashMap<>();

    public QuestionDeck() {
        questions.put(POP, createQuestions(POP));
        questions.put(SCIENCE, createQuestions(SCIENCE));
        questions.put(SPORTS, createQuestions(SPORTS));
        questions.put(QUESTION_CATEGORY_ROCK, createQuestions(QUESTION_CATEGORY_ROCK));
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
            case 0 -> POP;
            case 1 -> SCIENCE;
            case 2 -> SPORTS;
            default -> QUESTION_CATEGORY_ROCK;
        };
    }

    public String askQuestion(String category) {
        return questions.get(category).poll();
    }
}
