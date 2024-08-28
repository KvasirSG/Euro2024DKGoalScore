import java.io.FileNotFoundException;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        testMatchResult();
        testMatchResultReader();
        testStatistics();
    }

    private static void testMatchResult() {
        System.out.println("Testing MatchResult...");

        List<String> goalScorers = Arrays.asList("Højlund", "Wind", "Højbjerg");
        MatchResult matchResult = new MatchResult("Denmark-Finland", goalScorers);

        // Test getGoalScorers method
        if (matchResult.getGoalScorers().equals(goalScorers)) {
            System.out.println("getGoalScorers: PASS");
        } else {
            System.out.println("getGoalScorers: FAIL");
        }

        // Test getMatchName method
        if (matchResult.getMatchName().equals("Denmark-Finland")) {
            System.out.println("getMatchName: PASS");
        } else {
            System.out.println("getMatchName: FAIL");
        }

        System.out.println();
    }

    private static void testMatchResultReader() {
        System.out.println("Testing MatchResultReader...");

        MatchResultFileReader reader = new MatchResultFileReader();
        try {
            List<MatchResult> results = reader.readFile("Euro2024QualifyingRound.csv");

            // Test the number of MatchResult objects created
            if (results.size() > 0) {
                System.out.println("readFile: PASS (read " + results.size() + " matches)");
            } else {
                System.out.println("readFile: FAIL");
            }

            // Additional tests could be added here based on the expected content of the CSV file

        } catch (FileNotFoundException e) {
            System.out.println("readFile: FAIL (FileNotFoundException)");
        }

        System.out.println();
    }

    private static void testStatistics() {
        System.out.println("Testing Statistics...");

        try {
            Statistics stats = new Statistics("Euro2024QualifyingRound.csv");

            // Test getGoalScorers method
            Set<String> goalScorers = stats.getGoalScorers();
            if (goalScorers.size() > 0) {
                System.out.println("getGoalScorers: PASS");
            } else {
                System.out.println("getGoalScorers: FAIL");
            }

            // Test getGoalScorersWithTotals method
            Map<String, Integer> scorersWithTotals = stats.getGoalScorersWithTotals();
            if (scorersWithTotals.size() > 0) {
                System.out.println("getGoalScorersWithTotals: PASS");
            } else {
                System.out.println("getGoalScorersWithTotals: FAIL");
            }

            // Test getNumberOfGoals method
            String exampleScorer = "Højlund";
            int goals = stats.getNumberOfGoals(exampleScorer);
            if (goals > 0) {
                System.out.println("getNumberOfGoals: PASS (" + exampleScorer + " scored " + goals + " goals)");
            } else {
                System.out.println("getNumberOfGoals: FAIL");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Statistics: FAIL (FileNotFoundException)");
        }

        System.out.println();
    }
}
