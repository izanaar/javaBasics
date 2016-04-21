package bakery.desserts;

import bakery.Dessert;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cookie")
public class Cookie implements Dessert {
    @Override
    public void introduce() {
        System.out.println("I'm a cookie!");
    }
}
