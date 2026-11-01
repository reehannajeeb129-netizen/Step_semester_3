import java.util.Arrays;

public class Problem2_PrizeTable {
    static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int i = 0; i < marks.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    static void show(int[] marks) {
        int swaps = prizeTable(marks);
        System.out.println(Arrays.toString(marks) + "     swaps = " + swaps);
    }

    public static void main(String[] args) {
        show(new int[] {45, 90, 60, 75});
        show(new int[] {80, 70, 60});
        System.out.println("Own test:");
        show(new int[] {10, 50, 30, 50, 20});
    }
}
