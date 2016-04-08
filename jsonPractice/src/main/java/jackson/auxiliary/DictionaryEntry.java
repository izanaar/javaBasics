package jackson.auxiliary;

public class DictionaryEntry {

    private Definition[] def;


    public DictionaryEntry() {

    }

    public Definition[] getDefinitions() {
        return def;
    }

    public void setDefinitions(Definition[] definitions) {
        this.def = definitions;
    }
}
