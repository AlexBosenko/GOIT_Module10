package contentreader;

import java.io.File;
import java.util.*;

public class ContentReader implements FileContentReader {
    @Override
    public List<String> read(File file) {
        List<String> result = new ArrayList<>();

        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public Map<String, Integer> read(File file, int rowSkip) {
        Map<String, Integer> result = new HashMap<>();
        int rowCount = 0;

        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                rowCount++;
                if (rowCount <= rowSkip) {
                    continue;
                }

                String[] dataRow = row.split(" ");
                if (dataRow.length == 2) {
                    result.put(dataRow[0], Integer.valueOf(dataRow[1]));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }
}
