package jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.auxiliary.Definition;
import jackson.auxiliary.DicResult;

import java.io.FileReader;
import java.io.IOException;

public class Jck2 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Definition definition = mapper.readValue(new FileReader("definition.json"), Definition.class);
        DicResult dicResult = mapper.readValue(new FileReader("test.json"), DicResult.class);
    }
}
