package trivia;

import java.util.*;

public class QuestionDeck {
    private final Map<String, Queue<String>> questions = new HashMap<>();

    public QuestionDeck() {
        for (Category category : Category.values()) {
            questions.put(category.getDisplayName(), createQuestions(category.getDisplayName()));
        }
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
            case 0 -> Category.POP.getDisplayName();
            case 1 -> Category.SCIENCE.getDisplayName();
            case 2 -> Category.SPORTS.getDisplayName();
            default -> Category.ROCK.getDisplayName();
        };
    }

    public String askQuestion(String category) {
        return questions.get(category).poll();
    }

    public Queue<String> getQuestionsByCategory(String category) {
        return questions.get(category);
    }
}
