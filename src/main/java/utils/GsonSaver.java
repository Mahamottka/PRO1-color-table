package utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Barva;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class GsonSaver {
    public void uloz(String soubor, List<Barva> seznam) throws IOException {
        try (FileWriter vystup = new FileWriter(soubor)) {
            Gson gson = new Gson();
            String json = gson.toJson(seznam);
            vystup.write(json);
        }
    }
}
