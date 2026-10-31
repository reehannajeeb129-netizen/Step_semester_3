import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3_EvenOddCounter {
    public static void main(String[] args) throws IOException {
        String input = new String(System.in.readAllBytes());
        Matcher m = Pattern.compile("-?\\d+").matcher(input);
        List<Integer> numbers = new ArrayList<>();
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group()));
        }
        int even = 0;
        int odd = 0;
        for (int x : numbers) {
            if (x % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
