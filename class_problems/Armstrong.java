import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int origNumber, digit,m,number,sum=0;
        System.out.print("Enter number: ");
        origNumber = sc.nextInt();
        number = origNumber;
        while(number != 0){
            digit = number % 10;
            m = digit * digit * digit;
            sum = sum + m;
            number = number / 10;
        }
        if(sum == origNumber){
            System.out.println(origNumber + " is an Armstrong number.");
        }
        else{
            System.out.println(origNumber + " is not an Armstrong number.");
        }
        sc.close();
    }
}