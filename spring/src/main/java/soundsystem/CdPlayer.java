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
        cd.play();
    }

    @Override
    public CompactDisc getCompactDisk() {
        return cd;
    }

}
