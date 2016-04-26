package plain.bakery.config;

import plain.bakery.Bakery;
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
