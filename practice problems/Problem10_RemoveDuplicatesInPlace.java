import java.util.Arrays;

public class Problem10_RemoveDuplicatesInPlace {
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int next = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[next - 1]) {
                nums[next] = nums[i];
                next++;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int length = removeDuplicates(nums);
        System.out.println("length = " + length);
        System.out.println("nums[0.." + (length - 1) + "] = " + Arrays.toString(Arrays.copyOf(nums, length)));
    }
}
