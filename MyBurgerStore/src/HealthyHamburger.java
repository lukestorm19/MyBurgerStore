import java.util.List;
import java.util.stream.Collectors;


public class HealthyHamburger extends Hamburger {

    public HealthyHamburger(String meat) {
        super("Healthy Burger", RollType.BROWN_BREAD, meat, 20);
    }

    public HealthyHamburger(String meat, List<AdditionalItem> additionalItems) {
        super("Healthy Burger", RollType.BROWN_BREAD, meat, 20);
        if (!additionalItems.isEmpty() && additionalItems.size() <= 6) {
            this.additionalItems = additionalItems;
        }else {
            this.additionalItems = additionalItems.stream().limit(6).collect(Collectors.toList());
            System.out.println("The 'Healthy Burger' cannot contained more than 6 additions");
        }
    }

    @Override
    public void setAdditionalItems(List<AdditionalItem> additionalItems) {
        if (!additionalItems.isEmpty() && additionalItems.size() <= 6) {
            this.additionalItems = additionalItems;
        }else {
            this.additionalItems = additionalItems.stream().limit(6).collect(Collectors.toList());
            System.out.println("The Basic 'HamBurger' cannot contained more than 6 additions");
        }
    }

    @Override
    public  double getTotalPrice() {
        return super.getTotalPrice();
    }
}