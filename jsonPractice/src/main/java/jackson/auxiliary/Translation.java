package jackson.auxiliary;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Translation {

    @JsonProperty("text")
    private String text;

    @JsonProperty("pos")
    private String position;

    @JsonProperty("gen")
    private String gender;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
