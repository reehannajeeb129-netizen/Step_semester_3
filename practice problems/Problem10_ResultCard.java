import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Student {
    private final String name;
    private final int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.length;
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) {
            return "A";
        } else if (avg >= 75) {
            return "B";
        } else if (avg >= 60) {
            return "C";
        } else if (avg >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
}

public class Problem10_ResultCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pattern digits = Pattern.compile("-?\\d+");
        List<Student> students = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }
            int bracket = line.indexOf('[');
            String name = line.substring(0, bracket).trim();
            Matcher m = digits.matcher(line.substring(bracket));
            List<Integer> values = new ArrayList<>();
            while (m.find()) {
                values.add(Integer.parseInt(m.group()));
            }
            int[] marks = new int[values.size()];
            for (int i = 0; i < marks.length; i++) {
                marks[i] = values.get(i);
            }
            students.add(new Student(name, marks));
        }
        for (Student s : students) {
            System.out.printf(Locale.US, "%s: Average %.1f, Grade %s%n",
                    s.getName().toUpperCase(), s.getAverage(), s.getGrade());
        }
    }
}
