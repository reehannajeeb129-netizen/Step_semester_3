import java.util.Random;

public class BmiCalculator {

    public double calculateBmi(double heightInMeters, double weightInKg) {
        return weightInKg / (heightInMeters * heightInMeters);
    }

    public String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public void printWellnessReport(int teamSize) {
        Random randomGenerator = new Random();

        System.out.printf("%-10s %-14s %-14s %-8s %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

        for (int personNumber = 1; personNumber <= teamSize; personNumber++) {
            double height = 1.50 + (randomGenerator.nextDouble() * 0.45);
            double weight = 50.0 + (randomGenerator.nextDouble() * 50.0);

            double bmi = calculateBmi(height, weight);
            String status = getBmiStatus(bmi);

            System.out.printf("%-10s %-14.2f %-14.2f %-8.2f %-12s%n",
                    "Person " + personNumber, height, weight, bmi, status);
        }
    }

    public static void main(String[] args) {
        int teamSize = 10;
        BmiCalculator calculator = new BmiCalculator();
        calculator.printWellnessReport(teamSize);
    }
}
