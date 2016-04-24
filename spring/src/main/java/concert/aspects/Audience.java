package concert.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

    @Pointcut("execution(* concert.interf.Performance.perform(String)) && args(songName)")
    public void performance(String songName) {}

/*    @Before("performance(songName)")
    public void silenceCellPhones(String songName){
        System.out.println("Silencing cell phones before the performance.");
    }*/

    @Around("performance(songName)")
    public void wrapPerformance(ProceedingJoinPoint jp, String songName){
        System.out.println("The performance has started!");
        try {
            System.out.println("The band will be playing " + songName + ".");
            jp.proceed();
            System.out.println("The performance has ended.");
            jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
