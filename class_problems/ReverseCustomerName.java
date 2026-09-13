import java.util.Scanner;

public class ReverseCustomerName {

    public String reverseCustomerName(String customerName) {
        String reversedName = "";
        for (int i = customerName.length() - 1; i >= 0; i--) {
            reversedName = reversedName + customerName.charAt(i);
        }
        return reversedName;
    }

    public void printOriginalAndReversedName(String customerName) {
        String reversedName = reverseCustomerName(customerName);
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        ReverseCustomerName program = new ReverseCustomerName();

        System.out.print("Enter customer name: ");
        String customerName = inputScanner.nextLine();

        program.printOriginalAndReversedName(customerName);

        inputScanner.close();
    }
}
