package soundsystem.cd;

import soundsystem.interfaces.CompactDisc;

public class Unforgivable implements CompactDisc{

    @Override
    public void play() {
        System.out.println("But it ain't over till its over but I won't be made a fool");
    }
}
