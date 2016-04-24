package concert;

import concert.conf.ConcertConfig;
import concert.interf.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class ConcertTest {

    @Autowired
    Performance performance;

    @Test
    public void testConcertInit(){
        assertNotNull(performance);
        performance.perform("Imperium");
    }

}
