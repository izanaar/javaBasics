package soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soundsystem.config.SoundSystemConfig;
import soundsystem.interfaces.CompactDisc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemConfig.class)
@ActiveProfiles("trance")
public class CdPlayerTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    CdPlayer player;

    @Autowired
    CompactDisc cd;

    @Test
    public void contextLoads(){
        assertNotNull(cd);
    }

    @Test
    public void testPlay(){
        player.play();
        assertEquals(
               "I'm fine without you now, I've given you my heart.\n",
               systemOutRule.getLog());
    }

}