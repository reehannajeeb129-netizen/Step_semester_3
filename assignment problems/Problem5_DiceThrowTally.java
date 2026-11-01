import java.util.Arrays;

public class Problem5_DiceThrowTally {
    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int r : rolls) {
            count[r]++;
        }
        StringBuilder counts = new StringBuilder("Counts:");
        for (int v = 1; v <= 6; v++) {
            counts.append(" ").append(v).append(":").append(count[v]);
        }
        System.out.println(counts);

        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[index++] = v;
            }
        }
        System.out.println("Sorted: " + Arrays.toString(sorted));
        return sorted;
    }

    public static void main(String[] args) {
        diceSort(new int[] {4, 1, 6, 4, 2, 1, 4});
        System.out.println("Own test:");
        diceSort(new int[] {6, 6, 5, 3, 3, 3, 1, 2});
    }
}
