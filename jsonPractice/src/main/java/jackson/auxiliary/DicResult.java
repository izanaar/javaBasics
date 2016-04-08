package jackson.auxiliary;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DicResult {

    private String[] trash;



    public String[] getTrash() {
        return trash;
    }

    public void setTrash(String[] trash) {
        this.trash = trash;
    }

    @JsonProperty("def")
    private Definition[] definitions;

    public Definition[] getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Definition[] definitions) {
        this.definitions = definitions;
    }
}
