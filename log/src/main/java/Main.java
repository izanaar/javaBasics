import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

public class Main {

    static Logger logger = (Logger) LoggerFactory.getLogger("main");

    public static void main(String[] args) {
        logger.info("Logger says hello, mfcker.");

        logger.setLevel(Level.INFO);

        logger.trace("This message woun't be printed");

        logger.info("But this message would");

        new Thread(() ->{
            logger.info("Message from another thread.");
        },"log-thread").start();

        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        //StatusPrinter.print(lc);


    }
}
