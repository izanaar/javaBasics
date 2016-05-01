package bakery.desserts;


import bakery.intrface.Dessert;
import org.springframework.stereotype.Component;

@Component
public class Cookie implements Dessert {
    @Override
    public void introduce() {
        System.out.println("I'm a cookie!");
    }
}
