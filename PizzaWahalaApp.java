import java.util.Scanner;

public class PizzaWahalaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaTypes = {"sapa", "small money", "big boys", "odogwu"};
        int[] slicesPerBox = {4, 6, 8, 12};
        int[] pricesPerBox = {2000, 2400, 3000, 4200};

        System.out.println("Enter the number of guests:");
        int numGuests = scanner.nextInt();
        System.out.println("Enter the pizza type (sapa, small money, big boys, odogwu):");
        String pizzaType = scanner.next();

        int pizzaTypeIndex = -1;
        for (int count = 0; count < pizzaTypes.length; count++) {
            if (pizzaTypes[count].equals(pizzaType)) {
                pizzaTypeIndex = count;
                break;
            }
        }

        int numBoxes = numGuests / slicesPerBox[pizzaTypeIndex];
        if (numGuests % slicesPerBox[pizzaTypeIndex] != 0) {
            numBoxes++;
        }

        int slicesLeftOver = numBoxes * slicesPerBox[pizzaTypeIndex] - numGuests;

        int totalPrice = numBoxes * pricesPerBox[pizzaTypeIndex];

        System.out.println("Number of boxes of pizza to buy: " + numBoxes);
        System.out.println("Number of slices left over after serving: " + slicesLeftOver);
        System.out.println("Price: " + totalPrice);
    }
}
