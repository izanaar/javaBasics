package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Date;

@Configuration
public class CdPlayerConfig {

    @Bean
    @Profile("trance")
    public CompactDisc tranceCompactDisc(){
        return new Imagine();
    }

    @Bean
    @Profile("metalcore")
    public CompactDisc metalcoreCompactDisc(){
        return new Fever();
    }

    @Bean
    public MediaPlayer mediaPlayer(CompactDisc compactDisc){
        return new CdPlayer(compactDisc);
    }

}
