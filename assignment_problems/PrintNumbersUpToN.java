import java.util.Scanner;

public class PrintNumbersUpToN {

    static void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = sc.nextInt();

        printNumbersUpToN(n);

        sc.close();
    }
}