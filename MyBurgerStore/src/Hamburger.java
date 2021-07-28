import java.util.List;
import java.util.stream.Collectors;


public class Hamburger {
    protected List<AdditionalItem> additionalItems;
    private final String name;
    private final RollType rollType;
    private final String meat;
    private final double basePrice;

    public Hamburger(RollType rollType) {
        this.name = "Basic Hamburger";
        this.rollType = rollType;
        this.meat = "Beef";
        this.basePrice = 15;
    }

    public Hamburger(String name, RollType rollType, String meat, double basePrice) {
        this.name = name;
        this.rollType = rollType;
        this.meat = meat;
        this.basePrice = basePrice;
    }

    public Hamburger(String name, RollType rollType, String meat, double basePrice, List<AdditionalItem> additionalItems) {
        this.name = name;
        this.rollType = rollType;
        this.meat = meat;
        this.basePrice = basePrice;
        if (!additionalItems.isEmpty() && additionalItems.size() <=4) {
            this.additionalItems = additionalItems;
        }else {
            this.additionalItems = additionalItems.stream().limit(4).collect(Collectors.toList());
            System.out.println("The Basic 'HamBurger' cannot contained more than 4 additions");
        }
    }

    public String getName() {
        return name;
    }

    public RollType getRollType() {
        return rollType;
    }

    public String getMeat() {
        return meat;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public List<AdditionalItem> getAdditionalItems() {
        return additionalItems;
    }

    public void setAdditionalItems(List<AdditionalItem> additionalItems) {
        if (!additionalItems.isEmpty() && additionalItems.size() <=4) {
            this.additionalItems = additionalItems;
        }else {
            this.additionalItems = additionalItems.stream().limit(4).collect(Collectors.toList());
            System.out.println("The Basic 'HamBurger' cannot contained more than 4 additions");
        }
    }

    public double getTotalPrice() {
        if (additionalItems != null) {
            return getBasePrice() + this.additionalItems.stream().mapToDouble(AdditionalItem::getPrice).sum();
        } else {
            return getBasePrice();
        }
    }

    public void showBurgerInfo() {
        if (additionalItems != null) {
            System.out.println("Burger: " + getName() + " with " + getMeat() + ": " + getBasePrice() + "$" +
                    "\nAdditions: " + getAdditionalItems().toString() + "\n" +
                    "Total: " + getTotalPrice() +"$");
        } else {
            System.out.println("Burger: " + getName() + " with " + getMeat() + ": " + getBasePrice() + "$" +
                    "\nTotal: " + getTotalPrice() + "$\n");
        }
    }
}