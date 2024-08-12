import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	System.out.println("WELCOME TO JOHNSON CREDIT CARD VALIDITY CHECK");
        System.out.print("Hello, kindly enter card details to verify:\n ");
        String cardNumber = scanner.nextLine();

        String cardType = getCardType(cardNumber);
        int digitLength = cardNumber.length();
        String validityStatus = getValidityStatus(cardNumber);

        System.out.println("******************************************");
        System.out.println("**credit card type: " + cardType);
        System.out.println("**credit card number: " + cardNumber);
        System.out.println("**credit card digit length: " + digitLength);
        System.out.println("**credit card validity status: " + validityStatus);
        System.out.println("******************************************");
    }

    private static String getCardType(String cardNumber) {
        if (cardNumber.startsWith("4")) {
            return "Visa";
        } else if (cardNumber.startsWith("5")) {
            return "Mastercard";
        } else if (cardNumber.startsWith("37")) {
            return "American Express";
        } else if (cardNumber.startsWith("6")) {
            return "Discover";
        } else {
            return "Invalid card";
        }
    }

    private static String getValidityStatus(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int count = cardNumber.length() - 1; count >= 0; count--) {
            int num = Integer.parseInt(cardNumber.substring(count, count + 1));
            if (alternate) {
                num *= 2;
                if (num > 9) {
                    num -= 9;
                }
            }
            sum += num;
            alternate = !alternate;
        }
        return (sum % 10 == 0) ? "valid" : "invalid";
    }
}
