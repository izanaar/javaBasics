package soundsystem;

import soundsystem.interfaces.CompactDisc;
import soundsystem.interfaces.MediaPlayer;

public class CdPlayer2 implements MediaPlayer{

    private CompactDisc cd;

  /*  @Autowired
    @Qualifier("imagineCompactDisc")
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }
*/

    public CdPlayer2(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play(){
        cd.play();
    }

    public CompactDisc getCompactDisk() {
        return cd;
    }
}
