package contentreader;

import objecttojson.User;

import java.io.File;
import java.util.List;

public interface FileContentReader {
    List<String> read(File file);
    List<User> read(File file, int rowSkip);
}
