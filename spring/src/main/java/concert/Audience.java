package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

    @Pointcut("execution(* concert.Performance.perform(..))")
    public void performance() {}

    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones before the performance.");
    }

    @Around("performance()")
    public void wrapPerformance(ProceedingJoinPoint jp){
        System.out.println("The performance has started!");
        try {
            jp.proceed();
            System.out.println("The performance has ended.");
            jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
