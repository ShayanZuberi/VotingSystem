package com.example.votingsystem;
import java.sql.*;
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
            //working with the cnic
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver Loaded Successfully");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345");
                System.out.println("Connection Established!");
                Statement statement = con.createStatement();
                String query = "Select count(*) from votingsystem.citizen where cnic =" + id;
                ResultSet rs = statement.executeQuery(query);
                rs.next();
                int count = rs.getInt(1);

                //System.out.println("QUERY: "+query);
                //System.out.println("COUNT: "+count)
                if (count == 0){    //new voter
                    query = "INSERT into votingsystem.citizen values("+ id +")";
                    //System.out.println("QUERY: "+query);
                    statement.execute(query);
                    //rs.next();
                    System.out.println("Inserted into citizen");
                    query = "commit";
                    statement.execute(query);
                    query = "INSERT into votingsystem.temp values(" + id + ")";
                    statement.execute(query);
                    query = "commit";
                    statement.execute(query);
                    Stage win = (Stage) cnic.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CastVote.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    win.setTitle("Voting System");
                    win.setScene(scene);
                    win.show();
                }
                else if (count == 1){
                    query = "SELECT count(*) from votingsystem.vote where cnic = " + id;
                    System.out.println("QUERY: "+query);
                    rs = statement.executeQuery(query);
                    rs.next();
                    int vCount = rs.getInt(1);
                    System.out.println("VOTE COUNT: "+vCount);
                    if (vCount == 0){   //can cast a vote
                        query = "INSERT into votingsystem.temp values(" + id + ")";
                        statement.execute(query);
                        query = "commit";
                        statement.execute(query);
                        Stage win = (Stage) cnic.getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CastVote.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        win.setTitle("Voting System");
                        win.setScene(scene);
                        win.show();
                    }
                    else {  //can not cast a vote
                        System.out.println("You can not cast another vote");
                    }
                }
                con.close();
            }
            catch (ClassNotFoundException e){
                System.out.println("Driver Not Loaded!");
            } catch (SQLException e) {
                System.out.println("Connection not established");
                e.printStackTrace();
            }



        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void BtnResultsPressed(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Results.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage win = (Stage) cnic.getScene().getWindow();
        win.setTitle("Voting System");
        win.setScene(scene);
        win.show();

    }

}