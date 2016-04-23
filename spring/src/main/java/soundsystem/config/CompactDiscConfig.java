package soundsystem.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import soundsystem.cd.Fever;
import soundsystem.cd.Imagine;
import soundsystem.cd.Unforgivable;
import soundsystem.conditions.ImagineCDCondition;
import soundsystem.interfaces.CompactDisc;

@Configuration
public class CompactDiscConfig {

    @Bean
    public CompactDisc imagineCompactDisc(){
        return new Imagine();
    }

    @Bean
    public CompactDisc unforgivableCompactDisc(){return new Unforgivable();}

    @Bean
    @Profile("metalcore")
    public CompactDisc metalcoreCompactDisc(){
        return new Fever();
    }

}
