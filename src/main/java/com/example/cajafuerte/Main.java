package com.example.cajafuerte;

import com.example.cajafuerte.control.ControlCaja;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        showWindow("Login.fxml");
    }

    public static void showWindow(String fxml)  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));

            Parent node = fxmlLoader.load();
            Scene scene = new Scene(node);
            Stage window = new Stage();
            window.setScene(scene);
            window.show();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}