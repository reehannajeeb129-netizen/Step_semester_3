import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    protected final String text;
    protected final String correctAnswer;
    protected final String studentAnswer;
    protected final int points;

    public Question(String text, String correctAnswer, String studentAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract String getType();

    public abstract double grade();
}

class McqQuestion extends Question {
    public McqQuestion(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getType() {
        return "MCQ";
    }

    @Override
    public double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getType() {
        return "TF";
    }

    @Override
    public double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getType() {
        return "ESSAY";
    }

    @Override
    public double grade() {
        String answer = studentAnswer.toLowerCase();
        int hits = 0;
        for (String keyword : correctAnswer.split(",")) {
            String key = keyword.trim().toLowerCase();
            if (!key.isEmpty() && answer.contains(key)) {
                hits++;
            }
        }
        if (hits >= 2) return points * 0.75;
        if (hits == 1) return points * 0.50;
        return 0;
    }
}

public class Problem4_ExamGrader {
    static Question create(List<String> t) {
        String text = t.get(1);
        String correct = t.get(2);
        String student = t.get(3);
        int points = Integer.parseInt(t.get(4));
        switch (t.get(0)) {
            case "MCQ":
                return new McqQuestion(text, correct, student, points);
            case "TF":
                return new TrueFalseQuestion(text, correct, student, points);
            default:
                return new EssayQuestion(text, correct, student, points);
        }
    }

    static String nextLine(BufferedReader br) throws IOException {
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        return line;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(nextLine(br).trim());
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = nextLine(br);
            Matcher m = pattern.matcher(line);
            List<String> tokens = new ArrayList<>();
            while (m.find()) {
                tokens.add(m.group(1) != null ? m.group(1) : m.group(2));
            }
            questions.add(create(tokens));
        }
        double total = 0;
        for (Question q : questions) {
            double score = q.grade();
            total += score;
            System.out.printf(Locale.US, "%s: %.2f%n", q.getType(), score);
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}
