package plain.concert.conf;

import plain.concert.aspects.Audience;
import plain.concert.band.MachineHead;
import plain.concert.interf.Performance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ConcertConfig {

    @Bean
    public Audience getAudience(){
        return new Audience();
    }

    @Bean
    public Performance getPerformance(){
        return new MachineHead();
    }

}
