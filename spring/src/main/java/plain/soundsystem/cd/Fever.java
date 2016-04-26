package plain.soundsystem.cd;

import org.springframework.beans.factory.annotation.Value;
import plain.soundsystem.interfaces.CompactDisc;

public class Fever implements CompactDisc {

    @Value("${metalcore.artist}")
    private String artist;

    @Value("${metalcore.title}")
    private String title;


    public Fever() {
    }

    @Override
    public void play() {
        System.out.println("Am I going insane? My blood is boiling inside of my veins!");
    }

    @Override
    public String getArtist() {
        return "Bullet for my Valentine";
    }

    @Override
    public String getTitle() {
        return "Fever";
    }
}
