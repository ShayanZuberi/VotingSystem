package com.example.votingsystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class ResultsController {

    @FXML
    private TextArea pmlnVotes;

    @FXML
    private TextArea pppVotes;

    @FXML
    private TextArea ptiVotes;

    @FXML
    private TextArea tlpVotes;

    @FXML
    private TextField winnerText;

    @FXML
    void revealPressed(ActionEvent event) {
        pmlnVotes.setText("WINNER: ");
        int ptiV = -1;
        int pmlnV = -1;
        int pppV = -1;
        int tlpV = -1;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded Successfully");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");
            System.out.println("Connection Established!");
            Statement statement = con.createStatement();
            String query = "select count(*) from vote where party_id = 1";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            ptiV = rs.getInt(1);
            query = "select count(*) from vote where party_id = 2";
            rs = statement.executeQuery(query);
            rs.next();
            pmlnV = rs.getInt(1);
            query = "select count(*) from vote where party_id = 3";
            rs = statement.executeQuery(query);
            rs.next();
            pppV = rs.getInt(1);
            query = "select count(*) from vote where party_id = 4";
            rs = statement.executeQuery(query);
            rs.next();
            tlpV = rs.getInt(1);

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String temp = "PTI Vote Count: " + ptiV;
        ptiVotes.setText(temp);
        temp = "PMLN Vote Count: " + pmlnV;
        pmlnVotes.setText(temp);
        temp = "PPP Vote Count: " + pppV;
        pppVotes.setText(temp);
        temp = "TLP Vote Count: " + tlpV;
        tlpVotes.setText(temp);

        String winner = "ELECTION WINNERS: ";
        if (ptiV >= pmlnV && ptiV>= pppV && ptiV>=tlpV){
            winner += "PTI";

        }
        else if (pmlnV>=ptiV && pmlnV>=pppV && pmlnV>=tlpV){
            winner += "PMLN";
        }
        else if (pppV>=ptiV && pppV>=pmlnV && pppV>=tlpV){
            winner += "PPP";
        }
        else if (tlpV>=ptiV && tlpV>=pmlnV && tlpV>=pppV){
            winner += "TLP";
        }
        winnerText.setText(winner);

    }
    @FXML
    void HomePressed(ActionEvent event) {
        try {
            Stage win = (Stage) pmlnVotes.getScene().getWindow();
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