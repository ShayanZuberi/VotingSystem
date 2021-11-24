package com.example.votingsystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CastVoteController {

    @FXML
    private Button btltlp;

    @FXML
    private Button btnpmln;

    @FXML
    private Button btnppp;

    @FXML
    private Button homebtn;

    @FXML
    private Button ptibtn;

    @FXML
    void BtnPTIClicked(ActionEvent event) {

    }

    @FXML
    void BtnPmlnClicked(ActionEvent event) {

    }

    @FXML
    void BtnPppClicked(ActionEvent event) {

    }

    @FXML
    void BtnTlpClicked(ActionEvent event) {

    }

    @FXML
    void BtnHomeClicked(ActionEvent event) {
        try {
            Stage win = (Stage) homebtn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
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