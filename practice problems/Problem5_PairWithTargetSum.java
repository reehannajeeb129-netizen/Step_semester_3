import java.util.HashSet;
import java.util.Set;

public class Problem5_PairWithTargetSum {
    static int[] findPair(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains(target - x)) {
                return new int[] {target - x, x};
            }
            seen.add(x);
        }
        return null;
    }

    static boolean hasPairWithSum(int[] nums, int target) {
        return findPair(nums, target) != null;
    }

    static boolean hasPairWithSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    static void show(int[] nums, int target) {
        int[] pair = findPair(nums, target);
        if (pair != null) {
            System.out.println("true (" + pair[0] + " + " + pair[1] + " = " + target + ")");
        } else {
            System.out.println("false");
        }
        System.out.println("  brute force agrees: "
                + (hasPairWithSumBruteForce(nums, target) == hasPairWithSum(nums, target)));
    }

    public static void main(String[] args) {
        show(new int[] {2, 7, 11, 15}, 9);
        show(new int[] {3, 4, 6}, 20);
    }
}
