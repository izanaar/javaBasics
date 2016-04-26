package plain.soundsystem;

import plain.soundsystem.interfaces.CompactDisc;
import plain.soundsystem.interfaces.MediaPlayer;

public class CdPlayer implements MediaPlayer {

    private CompactDisc cd;

  /*  @Autowired
    @Qualifier("imagineCompactDisc")
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }
*/

    public CdPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play(){
        System.out.println("Playing " + cd.getTitle() + " by " + cd.getArtist() + ".");
    }

    @Override
    public CompactDisc getCompactDisk() {
        return cd;
    }

}
