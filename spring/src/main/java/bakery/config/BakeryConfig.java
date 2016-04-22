package bakery.config;

import bakery.Bakery;
import bakery.Taster;
import bakery.desserts.Cake;
import bakery.intrface.Dessert;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = Bakery.class)
public class BakeryConfig {

    /*@Bean
    public Taster getTaster(){
        return new Taster();
    }

    @Bean
    public Dessert getCake(){
        return new Cake();
    }
*/
}
