package objecttojson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class ObjectToJson {
    public String getJsonUser(List<User> listUser) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(listUser);
    }
}
