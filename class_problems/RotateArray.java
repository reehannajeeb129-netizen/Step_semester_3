import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k (rotation amount): ");
        int k = sc.nextInt();

        int[] result = rotateArray(nums, k);
        System.out.println("Rotated array: " + Arrays.toString(result));

        sc.close();
    }
}