package contentreader;

import objecttojson.User;

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
    public List<User> read(File file, int rowSkip) {
        List<User> listUser = new ArrayList<>();
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
                    listUser.add(new User(dataRow[0], Integer.valueOf(dataRow[1])));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listUser;
    }
}
