package jackson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.auxiliary.Albums;
import jackson.auxiliary.Dataset;

public class Jck1 {
    public static void main(String[] args) throws IOException {
        String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=2";
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Albums albums = mapper.readValue(new URL(url), Albums.class);
        Dataset[] datasets = albums.getDataset();
        for (Dataset dataset : datasets) {
            System.out.println(dataset.getAlbum_title());
        }
    }
}
