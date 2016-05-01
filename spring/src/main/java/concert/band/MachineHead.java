package concert.band;

import concert.interf.Performance;

public class MachineHead implements Performance {

    @Override
    public void perform(String songName) {
        System.out.println("Machine head is playing " + songName + ".");
    }
}
