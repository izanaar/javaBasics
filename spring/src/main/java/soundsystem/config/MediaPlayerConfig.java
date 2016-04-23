package soundsystem.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import soundsystem.CdPlayer;
import soundsystem.interfaces.CompactDisc;
import soundsystem.interfaces.MediaPlayer;

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
        return new CdPlayer(cd);
    }
}
