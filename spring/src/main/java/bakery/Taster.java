package bakery;

import bakery.intrface.Dessert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Taster {

    private Dessert dessert;

    public void taste(){
        dessert.introduce();
    }

    @Autowired
    @Qualifier("iceCream")
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
}

