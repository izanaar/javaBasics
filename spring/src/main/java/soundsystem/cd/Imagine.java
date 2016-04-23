package soundsystem.cd;

import org.springframework.stereotype.Component;
import soundsystem.interfaces.CompactDisc;

public class Imagine implements CompactDisc {
    public void play() {
        System.out.println("I'm fine without you now, I've given you my heart.");
    }
}
