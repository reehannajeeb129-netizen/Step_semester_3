import java.util.Scanner;

public class Problem6_ClassAttendanceTracker {
    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int longest = 0;
        int run = 0;
        for (int d : days) {
            if (d == 1) {
                present++;
                run++;
                if (run > longest) {
                    longest = run;
                }
            } else {
                run = 0;
            }
        }
        return new int[] {present, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }
        int[] result = attendanceSummary(days);
        System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
    }
}
