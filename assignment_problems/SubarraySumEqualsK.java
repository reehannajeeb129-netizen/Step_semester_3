import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); 

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];

            int needed = currentSum - k;
            if (prefixCount.containsKey(needed)) {
                count = count + prefixCount.get(needed);
            }

            if (prefixCount.containsKey(currentSum)) {
                prefixCount.put(currentSum, prefixCount.get(currentSum) + 1);
            } else {
                prefixCount.put(currentSum, 1);
            }
        }

        return count;
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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = subarraySum(nums, k);
        System.out.println("Number of subarrays with sum " + k + ": " + result);

        sc.close();
    }
}
