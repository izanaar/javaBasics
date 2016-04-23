package soundsystem;

import soundsystem.interfaces.CompactDisc;
import soundsystem.interfaces.MediaPlayer;

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
        System.out.println("Playing " + cd.getArtist() + " by " + cd.getTitle() + ".");
    }

    @Override
    public CompactDisc getCompactDisk() {
        return cd;
    }

}
