package com.example.cajafuerte.control;

import com.example.cajafuerte.Main;
import com.example.cajafuerte.model.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class ControlCaja implements Initializable {

    @FXML
    private TextArea content;

    @FXML
    void closeBox(ActionEvent event) {
        String conten=content.getText();
        Data.getInstance().getContent().setContent(conten);
        saveData(conten);
        Main.showWindow("Login.fxml");
        Stage currentStage = (Stage) content.getScene().getWindow();
        currentStage.hide();
    }

    @FXML
    void passChange(ActionEvent event) {
        String conten=content.getText();
        Data.getInstance().getContent().setContent(conten);
        saveData(conten);
        Main.showWindow("Contra.fxml");
        Stage currentStage = (Stage) content.getScene().getWindow();
        currentStage.hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String conten = Data.getInstance().getContent().getContent();
        saveData(conten);
        content.setText(conten);
    }

    public void saveData(String a) {
        try {
            FileOutputStream fos = new FileOutputStream(new File("Content.txt"));
            fos.write(a.getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
