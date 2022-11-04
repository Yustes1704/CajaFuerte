package com.example.cajafuerte.control;

import com.example.cajafuerte.Main;
import com.example.cajafuerte.model.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ControlLogin {

    @FXML
    private Button boton;

    @FXML
    private TextField tx1;

    @FXML
    private TextField tx2;

    @FXML
    private TextField tx3;

    @FXML
    private TextField tx4;

    @FXML
    private TextField tx5;

    @FXML
    private TextField tx6;

    @FXML
    private HBox boxes;

    @FXML
    void onKey(KeyEvent event) {
        if (event.getSource().equals(tx1)) {
            tx2.requestFocus();
        }
        if (event.getSource().equals(tx2)) {
            tx3.requestFocus();
        }
        if (event.getSource().equals(tx3)) {
            tx4.requestFocus();
        }
        if (event.getSource().equals(tx4)) {
            tx5.requestFocus();
        }
        if (event.getSource().equals(tx5)) {
            tx6.requestFocus();
        }
    }

    @FXML
    void press(ActionEvent event) {
        int pass1 = Integer.parseInt(tx1.getText());
        int pass2 = Integer.parseInt(tx2.getText());
        int pass3 = Integer.parseInt(tx3.getText());
        int pass4 = Integer.parseInt(tx4.getText());
        int pass5 = Integer.parseInt(tx5.getText());
        int pass6 = Integer.parseInt(tx6.getText());

        if (pass1 == Data.getInstance().getPass().getPass1() && pass2 == Data.getInstance().getPass().getPass2()
                && pass3 == Data.getInstance().getPass().getPass3() && pass4 == Data.getInstance().getPass().getPass4()
                && pass5 == Data.getInstance().getPass().getPass5() && pass6 == Data.getInstance().getPass().getPass6()) {

            Main.showWindow("CajaFuerte.fxml");
            Stage current = (Stage) tx6.getScene().getWindow();
            current.hide();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong password");
            alert.setContentText("You've written a wrong password");
            alert.showAndWait();
        }
    }
}


