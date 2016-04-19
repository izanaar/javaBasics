package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MediaPlayer {

    CompactDisc cd;

    @Autowired
    public MediaPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void play(){
        cd.play();
    }

}
