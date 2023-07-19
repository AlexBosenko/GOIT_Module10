import contentreader.ContentReader;
import contentreader.FileContentReader;
import objecttojson.ObjectToJson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ObjectToJsonTest {
    public static void main(String[] args) {
        FileContentReader contentReader = new ContentReader();
        File file = new File("files/file2.txt");

        if (!file.exists()) {
            throw new RuntimeException("File with name " + file.getName() + " not exists");
        }

        Map<String, Integer> usersData = contentReader.read(file, 1);
        if (usersData.size() > 0) {
            String jsonUsers = new ObjectToJson().getJsonUser(usersData);
            File jsonFile = new File("files/user.json");
            try (FileWriter writer = new FileWriter(jsonFile)) {
                writer.write(jsonUsers);
                writer.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
