package plain.soundsystem.cd;

import plain.soundsystem.interfaces.CompactDisc;

public class Imagine implements CompactDisc {

    String artist;
    String title;

    public Imagine() {
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Imagine(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    public void play() {
        System.out.println(title + " by " + artist);
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }
}
