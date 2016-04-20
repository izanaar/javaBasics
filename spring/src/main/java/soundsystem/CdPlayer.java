package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CdPlayer implements MediaPlayer{

    private CompactDisc cd;

    @Autowired
    public CdPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play(){
        cd.play();
    }

}
