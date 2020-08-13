package filehandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import components.*;

import java.io.FileWriter;
import java.nio.file.Path;

public class JsonWriter {
    private Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public void Write(abPlaceable equipment, Path outDir) throws Exception {
        String filename = equipment.LookupName().replace("/", "_") + ".json";
        FileWriter fw = new FileWriter(outDir.resolve(filename).toString());
        gson.toJson(equipment, fw);
        fw.flush();
        fw.close();
    }

    public void Write(Quirk quirk, Path outDir) throws Exception {
        String filename = quirk.getName().replace("/", "_") + ".json";
        FileWriter fw = new FileWriter(outDir.resolve(filename).toString());
        gson.toJson(quirk, fw);
        fw.flush();
        fw.close();
    }
}
