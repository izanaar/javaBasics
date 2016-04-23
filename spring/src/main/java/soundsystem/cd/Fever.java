package soundsystem.cd;

import soundsystem.interfaces.CompactDisc;

public class Fever implements CompactDisc {
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
