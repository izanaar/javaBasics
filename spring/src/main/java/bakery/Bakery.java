package plain.bakery;

import plain.bakery.config.BakeryConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Bakery {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BakeryConfig.class);
        String[] beans  = context.getBeanDefinitionNames();
        Taster taster = (Taster) context.getBean("taster");
        taster.taste();
    }
}
