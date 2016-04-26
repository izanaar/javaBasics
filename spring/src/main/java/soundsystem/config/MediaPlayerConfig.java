package plain.soundsystem.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import plain.soundsystem.CdPlayer;
import plain.soundsystem.CdPlayer2;
import plain.soundsystem.interfaces.CompactDisc;
import plain.soundsystem.interfaces.MediaPlayer;

@Configuration
public class MediaPlayerConfig {

    @Bean
    @Qualifier("first")
    public MediaPlayer getCdPlayer(@Qualifier("imagineCompactDisc") CompactDisc cd){
        return new CdPlayer(cd);
    }

    @Bean
    @Qualifier("second")
    public MediaPlayer getCdPlayer2(@Qualifier("imagineCompactDisc") CompactDisc cd){
        return new CdPlayer2(cd);
    }
}
