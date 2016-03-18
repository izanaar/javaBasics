import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    static Logger logger = (Logger) LoggerFactory.getLogger("main");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!Objects.equals(line = reader.readLine(), "")){
            logger.info("User says: " + line);

        }

    }

}
