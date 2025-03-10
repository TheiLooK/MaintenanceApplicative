package trivia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Queue;

class QuestionDeckTest {

    private QuestionDeck questionDeck;

    @BeforeEach
    void setUp() {
        questionDeck = new QuestionDeck();
    }

    @Test
    void testCreationDeck() {
        // Vérifier que le deck contient toutes les catégories
        for (Category category : Category.values()) {
            Queue<String> questions = questionDeck.getQuestionsByCategory(category.getDisplayName());
            assertNotNull(questions, "Les questions de la catégorie " + category.getDisplayName() + " doivent exister");
            assertEquals(50, questions.size(), "La catégorie " + category.getDisplayName() + " doit contenir 50 questions.");
        }
    }

    @Test
    void testGetCategory() {
        // Tester la méthode getCategory pour plusieurs positions
        assertEquals(Category.POP.getDisplayName(), questionDeck.getCategory(1));
        assertEquals(Category.SCIENCE.getDisplayName(), questionDeck.getCategory(2));
        assertEquals(Category.SPORTS.getDisplayName(), questionDeck.getCategory(3));
        assertEquals(Category.ROCK.getDisplayName(), questionDeck.getCategory(4));
        assertEquals(Category.POP.getDisplayName(), questionDeck.getCategory(5));
    }

    @Test
    void testAskQuestion() {
        // Tester la méthode askQuestion
        String category = Category.POP.getDisplayName();
        String question = questionDeck.askQuestion(category);

        // Vérifier que la question renvoyée est correcte
        assertNotNull(question, "La question ne doit pas être null");
        assertTrue(question.startsWith(category), "La question doit commencer par le nom de la catégorie");

        // Tester que la question a été supprimée de la queue
        Queue<String> questions = questionDeck.getQuestionsByCategory(category);
        assertEquals(49, questions.size(), "La taille de la catégorie après avoir demandé une question doit être de 49");
    }

    @Test
    void testExhaustingQuestions() {
        // Tester que l'on peut récupérer toutes les questions pour une catégorie
        String category = Category.ROCK.getDisplayName();
        for (int i = 0; i < 50; i++) {
            String question = questionDeck.askQuestion(category);
            assertNotNull(question, "La question ne doit pas être null");
            assertTrue(question.startsWith(category), "La question doit commencer par le nom de la catégorie");
        }

        // Après avoir épuisé les questions, la queue devrait être vide
        Queue<String> questions = questionDeck.getQuestionsByCategory(category);
        assertTrue(questions.isEmpty(), "Il ne devrait plus y avoir de questions restantes dans la catégorie.");
    }

    @Test
    void testAskQuestionFromEmptyCategory() {
        // Tester la situation où une catégorie n'a plus de questions
        String category = Category.ROCK.getDisplayName();
        // Retirer toutes les questions
        for (int i = 0; i < 50; i++) {
            questionDeck.askQuestion(category);
        }

        // Essayer d'obtenir une nouvelle question de la catégorie vide
        assertNull(questionDeck.askQuestion(category), "La méthode askQuestion devrait renvoyer null lorsque la catégorie est vide");
    }
}
