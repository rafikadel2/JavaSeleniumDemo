package helpers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class JsonReader {


    private static JsonReader jsonReader;
    private Gson gson;
    private JsonObject fileData;

    private JsonReader() {
        gson = new Gson();
    }

    public static JsonReader getInstance() {
        if (jsonReader == null) {
            jsonReader = new JsonReader();
        }
        return jsonReader;
    }

    public void readData(String path) {
        this.fileData = gson.fromJson(readFile(path), JsonObject.class);
    }

    public JsonArray readDataAsArray(String path) {
        return gson.fromJson(readFile(path), JsonArray.class);
    }

    private BufferedReader readFile(String filePath) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reader;
    }


    public String getExpectedValueAsString(String jsonPath) {
        Localization localization = Localization.getInstance();

        jsonPath= jsonPath.replace("$Locale$",".."+localization.getLocale().value+"-"+localization.getCountry().value);
        JsonArray resultAsArray=getExpectedValue(jsonPath);
        return resultAsArray.get(0).getAsString();
    }
    public JsonArray getExpectedValue(String jsonPath) {
        Configuration conf = Configuration.builder().jsonProvider(new GsonJsonProvider())
                .options(Option.SUPPRESS_EXCEPTIONS).build();
        return   JsonPath.using(conf).parse(fileData).read(jsonPath);


    }

}
