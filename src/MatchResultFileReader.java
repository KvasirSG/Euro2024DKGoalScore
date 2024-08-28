import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchResultFileReader {

    public List<MatchResult> readFile(String fileName) throws FileNotFoundException {
        List<MatchResult> matchResults = new ArrayList<>();
        Scanner sc = new Scanner(new File("src/Euro2024QualifyingRound.csv"));

        while (sc.hasNextLine()) {
            // Read the next line from the file
            String line = sc.nextLine();

            // Split the line into parts based on the ';' delimiter
            String[] parts = line.split(";");

            String teams = parts[0];
            List<String> goalScorers = new ArrayList<>();

            if (parts.length > 1) { // Check if there are goal scorers in the line
                // Split the goal scorers part using ',' as the delimiter
                String[] scorerNames = parts[1].split(",");

                // Iterate through each goal scorer and add to the list
                for (String scorer : scorerNames) {
                    goalScorers.add(scorer.trim()); // Remove any leading/trailing whitespace
                }
            }

            MatchResult matchResult = new MatchResult(teams, goalScorers);
            matchResults.add(matchResult);
        }

        // Close the scanner to free up resources
        sc.close();

        return matchResults;
    }
}
