import ch.qos.logback.classic.Logger;
import chk.Descendant;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {

    static Logger     root = (Logger) LoggerFactory.getLogger("ROOT"),
                    logger = (Logger) LoggerFactory.getLogger(Main.class),
                descendant = (Logger) LoggerFactory.getLogger(Descendant.class);


    public static void main(String[] args) throws IOException {
        System.out.println("root level: " + root.getLevel());
        System.out.println("main level: " + logger.getLevel());
        System.out.println("desc level: " + descendant.getEffectiveLevel());
    }

}
