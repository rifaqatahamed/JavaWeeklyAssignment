public class BankTransactionReferenceValidator {
    static String normalizeReference(String raw) {
        raw = raw.trim();
                if (raw.length() >= 3) {
            String bankCode = raw.substring(0, 3).toUpperCase();
            String remaining = raw.substring(3);
            raw = bankCode + remaining;
        }
        return raw;
    }
        static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9);
        String formattedDate = date.substring(0, 2)
                + "/" + date.substring(2, 4)
                + "/" + date.substring(4, 6);
        StringBuilder result = new StringBuilder();
        result.append("[");
        result.append(reference.substring(0, 3));
        result.append("] DATE: ");
        result.append(formattedDate);
        result.append(" | SEQ: ");
        result.append(sequence);
        return result.toString();
    }
    public static void main(String[] args) {
        String rawReference = " hdf03022600042 ";
        String normalizedReference = normalizeReference(rawReference);
        String result = validateAndFormat(normalizedReference);
        System.out.println(result);
    }
}