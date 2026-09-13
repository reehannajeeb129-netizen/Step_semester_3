public class MaskedPhoneNumberFormatter {

    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        // Validate all characters are digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String lastFour = phone.substring(phone.length() - 4);

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.insert(sb.length(), "-");
        sb.append(lastFour);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}
