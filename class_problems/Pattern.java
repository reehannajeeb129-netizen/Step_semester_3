import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r,i,j;
        System.out.print("Enter no . of rows: ");
        r = sc.nextInt();

        for (i = 1; i <= r; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    sc.close();
    }
}