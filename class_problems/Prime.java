import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int p = sc.nextInt();
        boolean isPrime = true;
        for (int i = 2; i < p; i++) {
            if (p % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime== true) {
            System.out.println(p + " is a prime number.");
        } else {
            System.out.println(p + " is not a prime number.");
        }
    }
}