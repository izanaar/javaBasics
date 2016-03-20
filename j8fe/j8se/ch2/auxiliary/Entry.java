package j8se.ch2.auxiliary;

public class Entry{
    private int id;
    private String text;

    public Entry() {
    }


    public Entry(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Entry(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "entry " + id + " contents: " + text + ";";
    }
}
