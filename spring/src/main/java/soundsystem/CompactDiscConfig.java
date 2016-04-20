package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import soundsystem.interfaces.CompactDisc;

@Configuration
public class CompactDiscConfig {

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

}
