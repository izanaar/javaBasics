package soundsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import soundsystem.CdPlayer;
import soundsystem.interfaces.CompactDisc;
import soundsystem.interfaces.MediaPlayer;

@Configuration
public class MediaPlayerConfig {

    @Bean
    public MediaPlayer mediaPlayer(CompactDisc compactDisc){
        return new CdPlayer(compactDisc);
    }

}
