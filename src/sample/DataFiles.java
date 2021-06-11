package sample;

import Users.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class DataFiles {

    Path usersPath = Paths.get("usersInfo.txt");

    public DataFiles() {
        createFile();
    }

    public void createFile() {
        try {
            if (Files.exists(usersPath)) {
                System.out.println("File already exists");
            } else {
                Path donePath = Files.createFile(usersPath);
                System.out.println("File Created Successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertUser(User user) {

        try {
            Files.write(usersPath, (user.toString() + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<String> s = null;
        try {
            s = Files.readAllLines(usersPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<User> users = s.stream().map(userString -> {
            String arr[] = userString.split("-");
            return new User(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), arr[5], arr[6]);
        }).collect(Collectors.toList());


        return users;
    }

    public void updateUser(User updatedUser) {
        List<User> users = getAllUsers();
        users.remove(updatedUser);
        User newUser = updatedUser;
        users.add(newUser);
        users.sort(User.BY_ID);
        List<String> usersStrings = users.stream().map(user -> user.toString()).collect(Collectors.toList());
        try {
            Files.write(usersPath, usersStrings);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public User getUser(String email) {

        User user = new User();

        try {
            Files.lines(usersPath).forEach(Line -> {
                        String s[] = Line.split("-");

                        if (s[2].equalsIgnoreCase(email)) {
                            user.setID(Integer.parseInt(s[0]));
                            user.setName(s[1]);
                            user.setMail(s[2]);
                            user.setPassword(s[3]);
                            user.setAge(Integer.parseInt(s[4]));
                            user.setGender(s[5]);
                            user.setBloodType(s[6]);
                            return;
                        }

                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

}