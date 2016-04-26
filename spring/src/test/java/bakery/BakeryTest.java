package plain.bakery;

import plain.bakery.config.BakeryConfig;
import plain.bakery.intrface.Dessert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BakeryConfig.class)
public class BakeryTest {

    @Autowired
    @Qualifier("cookie")
    Dessert dessert;

    @Autowired
    Taster taster;

    @Test
    public void contextInit(){
        assertNotNull(dessert);
        dessert.introduce();
    }

    @Test
    public void tasterInit(){
        assertNotNull(taster);
    }
}
