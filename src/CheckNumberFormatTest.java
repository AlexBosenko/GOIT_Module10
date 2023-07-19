import contentreader.ContentReader;
import contentreader.FileContentReader;
import phonevalidator.CheckNumberFormat;

import java.io.File;
import java.util.List;

public class CheckNumberFormatTest {
    public static void main(String[] args) {
        FileContentReader contentReader = new ContentReader();
        File file = new File("files/file1.txt");

        if (!file.exists()) {
            throw new RuntimeException("File with name " + file.getName() + " not exists");
        }

        List<String> contents = contentReader.read(file);
        for (String content : contents) {
            if (new CheckNumberFormat().numberIsValid(content)) {
                System.out.println("correct number = " + content);
            }
        }
    }
}
