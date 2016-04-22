package bakery.desserts;

import bakery.intrface.Dessert;
import org.springframework.stereotype.Component;

@Component
public class IceCream implements Dessert {
    @Override
    public void introduce() {
        System.out.println("I'm an ice cream!");
    }
}
