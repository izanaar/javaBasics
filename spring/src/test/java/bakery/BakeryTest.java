package bakery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BakeryConfig.class)
public class BakeryTest {

    @Autowired
    Taster taster;

    @Autowired
    Dessert dessert;

    @Test
    public void contextInit(){
        assertNotNull(dessert);
        dessert.introduce();
    }

    @Test
    public void testTaste(){

        taster.taste();
    }

}
