public class AtmPinRetrySystem {

    static void atmPinRetry(String correctPin, String[] attempts) {
        int attemptCount = 0;
        boolean success = false;

        while (attemptCount < attempts.length && !success) {
            if (attempts[attemptCount].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }
            attemptCount++;
        }

        if (!success) {
            System.out.println("Card blocked — too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        atmPinRetry("4821", new String[]{"1111", "4821"});
        atmPinRetry("4821", new String[]{"1111", "2222", "3333"});
    }
}