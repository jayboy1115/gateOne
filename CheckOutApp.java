import java.util.Scanner;

public class CheckOutApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is the customer's name?\n ");
        String customerName = scanner.nextLine();

        System.out.print("What did the user buy?\n ");
        String productName = scanner.nextLine();

        System.out.print("How many pieces?\n ");
        int quantity = scanner.nextInt();

        System.out.print("How much per unit?\n ");
        double price = scanner.nextDouble();

        scanner.nextLine(); 

        System.out.print("Add more items? (yes/no):\n ");
        String response = scanner.nextLine();

        String[] productNames = new String[10];
        int[] quantities = new int[10];
        double[] prices = new double[10];
        int numProducts = 0;

        productNames[numProducts] = productName;
        quantities[numProducts] = quantity;
        prices[numProducts] = price;
        numProducts++;

        while (response.equalsIgnoreCase("yes")) {
            System.out.print("What did the user buy?\n ");
            productName = scanner.nextLine();

            System.out.print("How many pieces?\n ");
            quantity = scanner.nextInt();

            System.out.print("How much per unit?\n ");
            price = scanner.nextDouble();

            scanner.nextLine(); 

            productNames[numProducts] = productName;
            quantities[numProducts] = quantity;
            prices[numProducts] = price;
            numProducts++;

            System.out.print("Add more items? (yes/no):\n ");
            response = scanner.nextLine();
        }

        System.out.print("What is your name?\n ");
        String cashierName = scanner.nextLine();

        System.out.print("How much discount will he get?\n ");
        double discount = scanner.nextDouble();

        scanner.nextLine(); 

        System.out.println("SEMICOLON STORES MAIN BRANCH");
        System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
        System.out.println("TEL : 18-Dec-22 8:48:11 pm");
        System.out.println("Cashier: " + cashierName);
        System.out.println("Customer Name: " + customerName);
        System.out.println("==================================================================");

        System.out.println("ITEM\tQTY\tPRICE\tTOTAL(NGN)");
        System.out.println("-------------------------------------------------------------------");

        double subTotal = 0;
        for (int count = 0; count < numProducts; count++) {
            double total = quantities[count] * prices[count];
            subTotal += total;
            System.out.println(productNames[count] + "\t" + quantities[count] + "\t" + prices[count] + "\t" + total);
        }

        System.out.println("-------------------------------------------------------------------");
        System.out.println("Sub Total:\t" + subTotal);
        System.out.println("Discount:\t" + discount);
        System.out.println("Vat @ 17.50%:\t" + (subTotal * 0.175));
        System.out.println("==================================================================");
        System.out.println("Bill Total:\t" + (subTotal - discount + (subTotal * 0.175)));
        System.out.println("==================================================================");
        System.out.println("THIS IS NOT A RECEIPT KINDLY PAY " + (subTotal - discount + (subTotal * 0.175)));
        System.out.println("==================================================================");

        System.out.print("How much did the customer give you?\n ");
        double amountPaid = scanner.nextDouble();

        double balance = amountPaid - (subTotal - discount + (subTotal * 0.175));

System.out.println("SEMICOLON STORES MAIN BRANCH");
        System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
        System.out.println("TEL : 18-Dec-22 8:48:11 pm");
        System.out.println("Cashier: " + cashierName);
        System.out.println("Customer Name: " + customerName);
        System.out.println("==================================================================");

        System.out.println("ITEM\tQTY\tPRICE\tTOTAL(NGN)");
        System.out.println("-------------------------------------------------------------------");

        for (int count = 0; count < numProducts; count++) {
    double total = quantities[count] * prices[count];
    System.out.println(productNames[count] + "\t" + quantities[count] + "\t" + prices[count] + "\t" + total);
 }

        System.out.println("-------------------------------------------------------------------");
        System.out.println("Sub Total:\t" + subTotal);
        System.out.println("Discount:\t" + discount);
        System.out.println("Vat @ 17.50%:\t" + (subTotal * 0.175));
        System.out.println("==================================================================");
        System.out.println("Bill Total:\t" + (subTotal - discount + (subTotal * 0.175)));
        System.out.println("Amount Paid:\t" + amountPaid);
        System.out.println("Balance:\t" + balance);
        System.out.println("==================================================================");
        System.out.println("THANK YOU FOR YOUR PATRONAGE");
        System.out.println("==================================================================");
    }
}
