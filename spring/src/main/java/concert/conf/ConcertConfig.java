package concert.conf;

import concert.aspects.Audience;
import concert.band.MachineHead;
import concert.interf.Performance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ConcertConfig {

    @Bean
    public Performance getPerformance(){
        return new MachineHead();
    }

    @Bean
    public Audience audience(){
        return new Audience();
    }

}
