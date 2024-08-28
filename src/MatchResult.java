import java.util.List;

public class MatchResult {
    private String teams;  // Field to store the match name
    private List<String> goalScorers;

    public MatchResult(String teams, List<String> goalScorers) {
        this.teams = teams;
        this.goalScorers = goalScorers;
    }

    public List<String> getGoalScorers() {
        return goalScorers;
    }

    public String getMatchName() {
        return teams;
    }
}
