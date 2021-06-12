package sample;

import Users.LoginRegisterUtils;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToolbar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {
   LoginRegisterUtils log=new LoginRegisterUtils();
    @FXML
    private JFXTextField emailTextBox;

    @FXML
    private JFXTextField passwordTextBox;

    @FXML
    private JFXButton loginButton;

    @FXML
    private Hyperlink registerButton;

    @FXML
    void loginButtonPressed(ActionEvent event) {
      boolean isExist= log.validateUserLogin(emailTextBox.getText(),passwordTextBox.getText());
      if (isExist==true)
       System.out.println("Login Completed");
      else
       System.out.println("Wrong Email or Password");
    }

    @FXML
    void registerButtonPressed(ActionEvent event) {
     ChangeScene(event);

    }
 private void ChangeScene(ActionEvent event) {
  try {
   FXMLLoader fxmlLoader = new FXMLLoader();
   fxmlLoader.setLocation(getClass().getResource("RegisterPage.fxml"));
   Parent rootRegister = fxmlLoader.load();
   Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

   stage.setTitle("Fantasy");
   stage.setScene(new Scene(rootRegister));
//            stage.initStyle(StageStyle.UNDECORATED);
//            LoginBtn.getScene().getWindow().hide();
   stage.show();
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
}