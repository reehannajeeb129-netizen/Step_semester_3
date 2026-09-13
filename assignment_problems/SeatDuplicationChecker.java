public class SeatDuplicationChecker {

    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        boolean[] alreadyPrinted = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (alreadyPrinted[i]) continue; // avoid printing same duplicate twice
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                    alreadyPrinted[j] = true;
                    break; // one report per seat value is enough
                }
            }
        }

        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] test1 = {101, 102, 103, 102, 105};
        int[] test2 = {101, 102, 103, 104, 105};

        checkDuplicateSeats(test1); // Expected: Duplicate Seat Number Found: 102
        checkDuplicateSeats(test2); // Expected: No Duplicate Seats Found
    }
}
