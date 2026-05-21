package API;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileJsonReader {

    public static String read(String path){

        try {
            return Files.readString(Path.of(path));
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}