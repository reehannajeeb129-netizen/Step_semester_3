import java.util.Scanner;

public class Problem7_SecondBestScore {
    static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;
        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s < highest && s > second) {
                second = s;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        System.out.println(secondHighest(scores));
    }
}
