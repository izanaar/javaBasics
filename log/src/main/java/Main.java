import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import chk.CustomObject;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Main {

    static Logger logger = (Logger) LoggerFactory.getLogger("main");

    public static void main(String[] args) {
        long initTime = new Date().getTime();

        logger.info("Logger says hello, mfcker.");

        logger.setLevel(Level.INFO);

        logger.trace("This message woun't be printed");

        logger.info("But this message would");

        new Thread(() ->{
            logger.info("Message from another thread.");
        },"log-thread").start();


        CustomObject object = new CustomObject();

        //logger.debug("The entry is {}", object);

        logger.info("The entry is " + object);

        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        //StatusPrinter.print(lc);

        Thread killableThread = new Thread(() ->{
            object.toString();
        },"thread to kill");

        killableThread.start();

        killableThread.interrupt();

        System.out.println("Progam execution took " + (new Date().getTime() - initTime) + " milliseconds.");
    }


}
