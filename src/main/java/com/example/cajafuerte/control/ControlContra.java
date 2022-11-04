package com.example.cajafuerte.control;

import com.example.cajafuerte.Main;
import com.example.cajafuerte.model.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ControlContra {

    @FXML
    private HBox boxes1;

    @FXML
    private HBox boxesAct;

    @FXML
    private TextField tx1Act;

    @FXML
    private TextField tx1New;

    @FXML
    private TextField tx2Act;

    @FXML
    private TextField tx2New;

    @FXML
    private TextField tx3Act;

    @FXML
    private TextField tx3New;

    @FXML
    private TextField tx4Act;

    @FXML
    private TextField tx4New;

    @FXML
    private TextField tx5Act;

    @FXML
    private TextField tx5New;

    @FXML
    private TextField tx6Act;

    @FXML
    private TextField tx6New;

    @FXML
    void onKey(KeyEvent event) {
        if(event.getSource().equals(tx1Act)){
            tx2Act.requestFocus();
        }
        if(event.getSource().equals(tx2Act)){
            tx3Act.requestFocus();
        }
        if(event.getSource().equals(tx3Act)){
            tx4Act.requestFocus();
        }
        if(event.getSource().equals(tx4Act)){
            tx5Act.requestFocus();
        }
        if(event.getSource().equals(tx5Act)){
            tx6Act.requestFocus();
        }
    }

    @FXML
    void onKey2(ActionEvent event) {
        if(event.getSource().equals(tx1New)){
            tx2New.requestFocus();
        }
        if(event.getSource().equals(tx2New)){
            tx3New.requestFocus();
        }
        if(event.getSource().equals(tx3New)){
            tx4New.requestFocus();
        }
        if(event.getSource().equals(tx4New)){
            tx5New.requestFocus();
        }
        if(event.getSource().equals(tx5New)){
            tx6New.requestFocus();
        }
    }

    @FXML
    void claveCambiada(ActionEvent event) {
        int pass1 = Integer.parseInt(tx1Act.getText());
        int pass2 = Integer.parseInt(tx2Act.getText());
        int pass3 = Integer.parseInt(tx3Act.getText());
        int pass4 = Integer.parseInt(tx4Act.getText());
        int pass5 = Integer.parseInt(tx5Act.getText());
        int pass6 = Integer.parseInt(tx6Act.getText());

        if (pass1 == Data.getInstance().getPass().getPass1() && pass2 == Data.getInstance().getPass().getPass2()
                && pass3 == Data.getInstance().getPass().getPass3() && pass4 == Data.getInstance().getPass().getPass4()
                && pass5 == Data.getInstance().getPass().getPass5() && pass6 == Data.getInstance().getPass().getPass6()) {

            int pass1New =Integer.parseInt(tx1New.getText());
            int pass2New =Integer.parseInt(tx2New.getText());
            int pass3New =Integer.parseInt(tx3New.getText());
            int pass4New =Integer.parseInt(tx4New.getText());
            int pass5New =Integer.parseInt(tx5New.getText());
            int pass6New =Integer.parseInt(tx6New.getText());

            Data.getInstance().getPass().setPass1(pass1New);
            Data.getInstance().getPass().setPass2(pass2New);
            Data.getInstance().getPass().setPass3(pass3New);
            Data.getInstance().getPass().setPass4(pass4New);
            Data.getInstance().getPass().setPass5(pass5New);
            Data.getInstance().getPass().setPass6(pass6New);

            ArrayList<String> aux =new ArrayList<>();
            aux.add(tx1New.getText());
            aux.add(tx2New.getText());
            aux.add(tx3New.getText());
            aux.add(tx4New.getText());
            aux.add(tx5New.getText());
            aux.add(tx6New.getText());
            try {
                FileOutputStream fos = new FileOutputStream(new File("Pass.txt"));
                fos.write(aux.get(0).getBytes(StandardCharsets.UTF_8));
                fos.write(aux.get(1).getBytes(StandardCharsets.UTF_8));
                fos.write(aux.get(2).getBytes(StandardCharsets.UTF_8));
                fos.write(aux.get(3).getBytes(StandardCharsets.UTF_8));
                fos.write(aux.get(4).getBytes(StandardCharsets.UTF_8));
                fos.write(aux.get(5).getBytes(StandardCharsets.UTF_8));
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Main.showWindow("CajaFuerte.fxml");
            Stage currentStage = (Stage) tx6New.getScene().getWindow();
            currentStage.hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong password");
            alert.setContentText("You've written wrong password");
            alert.showAndWait();
        }
    }

    @FXML
    void close(ActionEvent event) {
        Main.showWindow("Login.fxml");
        Stage currentStage = (Stage) tx6New.getScene().getWindow();
        currentStage.hide();
    }

}
