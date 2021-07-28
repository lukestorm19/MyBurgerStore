import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hamburger hamburger;

        System.out.println("============= Bills Burgers =============");
        System.out.println("1. Healthy burger \n2. Deluxe burger \n3. Basic HamBurger");

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("======= Healthy burger =======  \n1. Beef \n" + "2. Chicken");

                switch (scanner.nextInt()) {
                    case 1:
                        hamburger = new HealthyHamburger("Beef");
                        break;
                    case 2:
                        hamburger = new HealthyHamburger("Chicken");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + scanner.nextInt());
                }

                List<AdditionalItem> additionalItems = new ArrayList<>();
                additions(scanner, additionalItems);
                hamburger.setAdditionalItems(additionalItems);
                break;
            case 2:
                hamburger = new DeluxeHamburger(RollType.WHEAT_BREAD);
                break;
            case 3:

                System.out.println("======= Hamburger ======= ");
                hamburger = new Hamburger(RollType.BROWN_BREAD);
                additionalItems = new ArrayList<>();

                additions(scanner, additionalItems);

                hamburger.setAdditionalItems(additionalItems);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + scanner.nextInt());
        }

        System.out.println("\n ======= CHECK OUT ORDER ======= \n");
        hamburger.showBurgerInfo();

    }

    private static void additions(Scanner scanner, List<AdditionalItem> additionalItems) {
        int additionSelection;

        do {
            System.out.println("Additions");
            System.out.println("1. tomato -> 0.5$");
            System.out.println("2. Lettuce -> 0.5$");
            System.out.println("3. Cheese -> 2$");
            System.out.println("4. Carrot -> 1$");
            System.out.println("5. Onion -> 1$");
            System.out.println("0. Done");

            additionSelection = scanner.nextInt();
            switch (additionSelection) {
                case 1:
                    additionalItems.add(new AdditionalItem("Tomato", 0.5));
                    break;
                case 2:
                    additionalItems.add(new AdditionalItem("Lettuce", 0.5));
                    break;
                case 3:
                    additionalItems.add(new AdditionalItem("Cheese", 2));
                    break;
                case 4:
                    additionalItems.add(new AdditionalItem("Carrot", 1));
                    break;
                case 5:
                    additionalItems.add(new AdditionalItem("Onion", 1));
                    break;
                case 0:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + scanner.nextInt());
            }
            System.out.println("Added: " + additionalItems.toString());
        } while (additionSelection != 0);
    }
}
