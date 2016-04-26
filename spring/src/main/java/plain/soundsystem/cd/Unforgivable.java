package plain.soundsystem.cd;

import org.springframework.beans.factory.annotation.Value;
import plain.soundsystem.interfaces.CompactDisc;

public class Unforgivable implements CompactDisc{

    @Value("#{imagineCompactDisc.artist}")
    private String artist;

    private String title;

    public Unforgivable() {
        title = "Unforgivable";
    }

    @Override
    public void play() {
        System.out.println("But it ain't over till its over but I won't be made a fool");
    }

    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
