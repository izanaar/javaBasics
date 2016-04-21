package bakery;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackageClasses = Dessert.class)
public class BakeryConfig {
}
