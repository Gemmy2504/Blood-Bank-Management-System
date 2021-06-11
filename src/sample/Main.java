package sample;

import java.io.IOException;

import javax.xml.crypto.Data;

import Users.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 717, 540));
        primaryStage.show();
    }


    public static void main(String[] args) {
//        launch(args);

        DataFiles files = new DataFiles();

        try {
//            files.insertUser(new User(1, "mohab", "mohab@gmail.com", "2r22r2r2r2", 20, "M", "A"));
            User u = files.getUser("hazem@gmail.com");
            System.out.println(u);
            System.out.println(files.getAllUsers());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
