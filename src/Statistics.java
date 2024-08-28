import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    // Map to store the number of goals scored by each player
    private Map<String, Integer> scores;

    // Constructor that initializes the scores map and reads data from the provided CSV file
    public Statistics(String filename) throws FileNotFoundException {
        scores = new HashMap<String, Integer>();

        // Scanner to read the file line by line
        Scanner sc = new Scanner(new File("src/Euro2024QualifyingRound.csv"));
        while (sc.hasNextLine()) {
            // Read the next line from the file
            String line = sc.nextLine();

            // Split the line into parts based on the ';' delimiter
            String[] parts = line.split(";");
            if (parts.length > 1) { // Check if there are goal scorers in the line
                // Split the goal scorers part using ',' as the delimiter
                String[] parts2 = parts[1].split(",");

                // Iterate through each goal scorer and update their goal count in the map
                for (String scorer : parts2) {
                    scorer = scorer.trim(); // Remove any leading/trailing whitespace
                    // Increment the goal count for the scorer, or add them if they are new
                    scores.put(scorer, scores.getOrDefault(scorer, 0) + 1);
                }
            }
        }

        // Close the scanner to free up resources
        sc.close();
    }

    // Method to return a set of all unique goal scorers
    public Set<String> getGoalScorers() {
        return new HashSet<>(scores.keySet());
    }

    // Method to return a map of goal scorers and their total goals
    public Map<String, Integer> getGoalScorersWithTotals() {
        return new HashMap<>(scores);
    }

    // Method to return the number of goals scored by a specific player
    public int getNumberOfGoals(String goalScorer) {
        return scores.getOrDefault(goalScorer, 0); // Return 0 if the player is not found
    }
}
