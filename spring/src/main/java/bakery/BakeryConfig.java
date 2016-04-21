package bakery;

import bakery.desserts.Cake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackageClasses = Dessert.class)
public class BakeryConfig {

    @Bean
    public Taster getTaster(){
        return new Taster();
    }

    @Bean
    public Dessert getCake(){
        return new Cake();
    }

}
