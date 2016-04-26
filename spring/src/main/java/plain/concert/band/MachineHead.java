package plain.concert.band;

import plain.concert.interf.Performance;

public class MachineHead implements Performance {

    @Override
    public void perform(String songName) {
        System.out.println("Machine head is playing " + songName + ".");
    }
}
