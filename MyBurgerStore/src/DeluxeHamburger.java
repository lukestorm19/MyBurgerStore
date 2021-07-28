import java.util.Arrays;

public class DeluxeHamburger extends Hamburger {

    public DeluxeHamburger(RollType rollType) {
        super("Deluxe Burger", rollType, "Sausage & Bacon", 25,
                Arrays.asList(
                        new AdditionalItem("Chips", 0),
                        new AdditionalItem("Drinks", 0)));
    }
}
