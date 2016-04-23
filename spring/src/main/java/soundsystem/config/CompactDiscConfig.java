package soundsystem.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import soundsystem.cd.Fever;
import soundsystem.cd.Imagine;
import soundsystem.cd.Unforgivable;
import soundsystem.interfaces.CompactDisc;

@Configuration
@PropertySource("classpath:app.properties")
public class CompactDiscConfig {

    @Autowired
    Environment environment;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CompactDisc imagineCompactDisc(){
        return new Imagine(environment.getProperty("imagine.artist"),
                environment.getProperty("imagine.title"));
    }

    @Bean
    public CompactDisc unforgivableCompactDisc(){return new Unforgivable();}

    @Bean
    @Profile("metalcore")
    public CompactDisc metalcoreCompactDisc(){
        return new Fever();
    }

}
