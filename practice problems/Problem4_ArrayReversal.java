import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem4_ArrayReversal {
    static void reverseInPlace(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) throws IOException {
        String input = new String(System.in.readAllBytes());
        Matcher m = Pattern.compile("-?\\d+").matcher(input);
        List<Integer> values = new ArrayList<>();
        while (m.find()) {
            values.add(Integer.parseInt(m.group()));
        }
        int[] tokens = new int[values.size()];
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = values.get(i);
        }
        reverseInPlace(tokens);
        System.out.println(Arrays.toString(tokens));
    }
}
