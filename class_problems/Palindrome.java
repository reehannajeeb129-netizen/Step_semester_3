import java.util.Scanner;

public class Palindrome{
    public static void main(String[] args){
        int origNumber,number,digit;
        int reversedNumber = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        origNumber = sc.nextInt();
        number = origNumber;
        while(number != 0){
            digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number = number / 10;
        }
        if (origNumber == reversedNumber) {
            System.out.println(origNumber + " is a palindrome.");
        } else {
            System.out.println(origNumber + " is not a palindrome.");
        }
        sc.close();
    }
}