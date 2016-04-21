package bakery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Taster {

    private Dessert dessert;

    public void taste(){
        dessert.introduce();
    }

    @Autowired
    @Qualifier("getCake")
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
}

