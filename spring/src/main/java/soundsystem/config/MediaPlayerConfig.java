package soundsystem.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soundsystem.CdPlayer;
import soundsystem.interfaces.CompactDisc;
import soundsystem.interfaces.MediaPlayer;

@Configuration
public class MediaPlayerConfig {

    @Bean
    public MediaPlayer getCdPlayer(@Qualifier("imagineCompactDisc") CompactDisc cd){
        return new CdPlayer(cd);
    }

}
