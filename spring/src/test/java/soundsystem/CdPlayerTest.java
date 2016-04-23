package soundsystem;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soundsystem.config.SoundSystemConfig;
import soundsystem.interfaces.CompactDisc;
import soundsystem.interfaces.MediaPlayer;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemConfig.class)
@ActiveProfiles("trance")
public class CdPlayerTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    @Qualifier("first")
    MediaPlayer player;

    @Autowired
    @Qualifier("second")
    MediaPlayer player2;

    @Autowired
    @Qualifier("unforgivableCompactDisc")
    CompactDisc cd;

    @Before
    public void setUp() throws Exception {
        System.setProperty("sprop", "system property value");
     /*   System.out.println(context.getEnvironment().getProperty("sprop"));.setProperty("sprop","system property value");*/
    }

    @Test
    public void contextLoads() {
        assertNotNull(cd);
        cd.play();
    }

    @Test
    public void testPlay() {
        player.play();
        assertEquals(
                "I'm fine without you now, I've given you my heart.\n",
                systemOutRule.getLog());
        assertNotSame(player.getCompactDisk(), player2.getCompactDisk());
    }

}
