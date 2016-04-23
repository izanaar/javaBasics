package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import soundsystem.interfaces.CompactDisc;
import soundsystem.interfaces.MediaPlayer;

@Component
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

}
