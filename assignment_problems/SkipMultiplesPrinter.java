public class SkipMultiplesPrinter{

    static void printSkippingMultiplesOfThree() {
        for (int i = 1; i <= 20; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        printSkippingMultiplesOfThree();
    }
}