public class Scorecard {
    private final boolean[] results;
    private int recorded = 0;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
    }

    public boolean recordAnswer(boolean correct) {
        if (recorded >= results.length) return false;
        results[recorded++] = correct;
        return true;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) score++;
        }
        return score;
    }
}
