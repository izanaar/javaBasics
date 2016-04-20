package soundsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import soundsystem.Fever;
import soundsystem.Imagine;
import soundsystem.conditions.TranceCDCondition;
import soundsystem.interfaces.CompactDisc;

@Configuration
public class CompactDiscConfig {

    @Bean
    @Conditional(TranceCDCondition.class)
    public CompactDisc tranceCompactDisc(){
        return new Imagine();
    }

    @Bean
    @Profile("metalcore")
    public CompactDisc metalcoreCompactDisc(){
        return new Fever();
    }

}
