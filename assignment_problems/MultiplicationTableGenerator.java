public class MultiplicationTableGenerator {

    static void generateFirstValidTable(int[] candidates) {
        for (int i = 0; i < candidates.length; i++) {
            int num = candidates[i];

            if (num < 1) {
                System.out.println("Skipping invalid number: " + num);
                continue;
            }

            for (int j = 1; j <= 10; j++) {
                System.out.println(num + " x " + j + " = " + (num * j));
            }
            break;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {-3, 0, 7, 9};
        generateFirstValidTable(candidates);
    }
}