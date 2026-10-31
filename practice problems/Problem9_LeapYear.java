import java.util.Scanner;

public class Problem9_LeapYear {
    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(isLeap(sc.nextInt()) ? "Leap year" : "Not a leap year");
        }
    }
}
