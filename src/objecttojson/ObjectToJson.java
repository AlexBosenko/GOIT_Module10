package objecttojson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ObjectToJson {
    public String getJsonUser(Map<String, Integer> usersData) {
        List<User> listUser = new ArrayList<>();
        for (String name : usersData.keySet()) {
            int age = usersData.get(name);
            User user = new User(name, age);
            listUser.add(user);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(listUser);
    }

    private static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
