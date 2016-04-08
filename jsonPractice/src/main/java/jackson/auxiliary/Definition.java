package jackson.auxiliary;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Definition {

    private String text;

    @JsonProperty("pos")
    private String position;

    @JsonProperty("tr")
    private Translation[] translations;

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

    public Translation[] getTranslations() {
        return translations;
    }

    public void setTranslations(Translation[] translations) {
        this.translations = translations;
    }
}
