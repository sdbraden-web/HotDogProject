
/**
 * This program makes a menu for a hot dog stand.
 * It prints all the different topping combinations and prices.
 *
 * @author Shanon Braden
 */
public class HotDog {

    /**
     * Prints all the possible hot dog combinations.
     *
     * @return the number of combinations
     */
    public long printMenu() {

        // Names of all the toppings
        String[] toppings = {
            "Ketchup", "Mustard", "Chopped Onions",
            "Tomato Wedge", "Sweet Relish",
            "Sport Peppers", "Sauerkraut"
        };

        // Prices of the toppings in cents
        int[] prices = {15, 17, 20, 25, 30, 35, 45};

        // Starting price and number of combinations
        int basePrice = 99;
        long count = 0;

        // Loop through all 128 combinations
        for (int i = 0; i < 128; i++) {

            // Start with just a hot dog
            int total = basePrice;
            String name = "Dog in Bun";
            int number = i;
            boolean first = true;

            // Check all seven toppings
            for (int j = 0; j < 7; j++) {

                // Check if the topping is included
                int choice = number % 2;
                number = number / 2;

                if (choice == 1) {

                    // Add "with" before the first topping
                    if (first) {
                        name = name + " with ";
                        first = false;
                    } else {
                        // Separate the other toppings with commas
                        name = name + ", ";
                    }

                    // Add the topping and its price
                    name = name + toppings[j];
                    total = total + prices[j];
                }
            }

            // Convert cents into dollars
            double dollars = total / 100.0;

            // Print the hot dog and its price
            System.out.printf("%3d %-85s $%.2f%n",
                count, name, dollars);

            // Count this combination
            count++;
        }

        // Return how many combinations were printed
        return count;
    }

    /**
     * Runs the hot dog program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        // Create the hot dog object
        HotDog obj = new HotDog();

        // Print the menu
        long count = obj.printMenu();

        // Check that there are 128 combinations
        assert count == 128;
    }
}




