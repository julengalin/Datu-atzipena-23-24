package dambi;
import java.io.FileReader;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;

public class JsonFitxategiaIrakurri {
    JsonReader reader = Json.createReader(new FileReader("jsondata.txt"));
    JsonStructure jsonst = reader.read();
}
