package com.example.votingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private TextArea cnic;

    @FXML
    void BtnProceedClicked(ActionEvent event) {
        try {
            String id = cnic.getText();
            Stage win = (Stage) cnic.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CastVote.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            win.setTitle("Voting System");
            win.setScene(scene);
            win.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}