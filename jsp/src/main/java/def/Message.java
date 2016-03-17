package def;

public class Message {

    int id;
    String text;

    public Message() {
        text = "Default text";
        id = Integer.MIN_VALUE;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }
}
