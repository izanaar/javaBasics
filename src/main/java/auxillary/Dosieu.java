package auxillary;

import java.io.Serializable;

/**
 * Created by ierus on 7/19/15.
 */
public class Dosieu implements Serializable, Comparable {
    private String name, note;

    public Dosieu(String name, String note) {
        this.name = name;
        this.note = note;
    }



    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "Name: " + name + "; note: " + note +".";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
