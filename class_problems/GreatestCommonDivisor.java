import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1,number2,reminder;
        System.out.println("Enter number 1: ");
        number1 = sc.nextInt();
        System.out.println("Enter number 2: ");
        number2 = sc.nextInt();
        while(number2 != 0){
            reminder = number1 % number2;
            number1 = number2;
            number2 = reminder;
        }
        System.out.println("GCD= " + number1);
        sc.close();
    }
}