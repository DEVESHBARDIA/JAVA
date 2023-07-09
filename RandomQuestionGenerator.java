package projects;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomQuestionGenerator {
    private static final int NUM_MODULES = 5;

    // Arrays for each module
    private static final String[][] moduleArrays = {
        {"word1", "word2", "word3", "word4", "word5"},
        {"word6", "word7", "word8", "word9", "word10"},
        {"word11", "word12", "word13", "word14", "word15"},
        {"word16", "word17", "word18", "word19", "word20"},
        {"word21", "word22", "word23", "word24", "word25"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of questions: ");
        int numQuestions = scanner.nextInt();

        System.out.print("Enter the module number (1-" + NUM_MODULES + "): ");
        int moduleNumber = scanner.nextInt();

        if (moduleNumber < 1 || moduleNumber > NUM_MODULES) {
            System.out.println("Invalid module number. Please try again.");
            return;
        }

        List<String> moduleQuestions = generateQuestions(numQuestions, moduleNumber);

        System.out.println("Randomly generated questions for Module " + moduleNumber + ":");
        for (String question : moduleQuestions) {
            System.out.println(question);
        }
    }

    private static List<String> generateQuestions(int numQuestions, int moduleNumber) {
        List<String> questions = new ArrayList<>();
        Random random = new Random();

        String[] moduleArray = moduleArrays[moduleNumber - 1];
        int arraySize = moduleArray.length;

        for (int i = 0; i < numQuestions; i++) {
            String word = moduleArray[random.nextInt(arraySize)];
            String question = "Question " + (i + 1) + ": " + word;
            questions.add(question);
        }

        return questions;
    }
}
