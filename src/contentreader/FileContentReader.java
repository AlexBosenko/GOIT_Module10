package contentreader;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface FileContentReader {
    List<String> read(File file);
    Map<String, Integer> read(File file, int rowSkip);
}
