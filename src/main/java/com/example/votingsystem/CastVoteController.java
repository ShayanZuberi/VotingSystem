package com.example.votingsystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

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
        int cnic=-1;
        Stage win = (Stage) btnppp.getScene().getWindow();
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345");
            System.out.println("Connection Established!");
            Statement statement = con.createStatement();

            String query = "SELECT * from votingsystem.temp";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            cnic = rs.getInt(1);
            query = "delete from votingsystem.temp";
            statement.execute(query);
            query = "commit";
            statement.execute(query);

            query = "INSERT into votingsystem.vote values(" + cnic + ",1)";
            statement.execute(query);
            query = "commit";
            statement.execute(query);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            win.setTitle("Voting System");
            win.setScene(scene);
            win.show();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void BtnPmlnClicked(ActionEvent event) {
        int cnic=-1;
        Stage win = (Stage) btnppp.getScene().getWindow();
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345");
            System.out.println("Connection Established!");
            Statement statement = con.createStatement();

            String query = "SELECT * from votingsystem.temp";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            cnic = rs.getInt(1);
            query = "delete from votingsystem.temp";
            statement.execute(query);
            query = "commit";
            statement.execute(query);

            query = "INSERT into votingsystem.vote values(" + cnic + ",2)";
            statement.execute(query);
            query = "commit";
            statement.execute(query);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            win.setTitle("Voting System");
            win.setScene(scene);
            win.show();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void BtnPppClicked(ActionEvent event) {
        int cnic=-1;
        Stage win = (Stage) btnppp.getScene().getWindow();
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345");
            System.out.println("Connection Established!");
            Statement statement = con.createStatement();

            String query = "SELECT * from votingsystem.temp";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            cnic = rs.getInt(1);
            query = "delete from votingsystem.temp";
            statement.execute(query);
            query = "commit";
            statement.execute(query);

            query = "INSERT into votingsystem.vote values(" + cnic + ",3)";
            statement.execute(query);
            query = "commit";
            statement.execute(query);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            win.setTitle("Voting System");
            win.setScene(scene);
            win.show();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void BtnTlpClicked(ActionEvent event) {
        int cnic=-1;
        Stage win = (Stage) btnppp.getScene().getWindow();
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345");
            System.out.println("Connection Established!");
            Statement statement = con.createStatement();

            String query = "SELECT * from votingsystem.temp";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            cnic = rs.getInt(1);
            query = "delete from votingsystem.temp";
            statement.execute(query);
            query = "commit";
            statement.execute(query);

            query = "INSERT into votingsystem.vote values(" + cnic + ",4)";
            statement.execute(query);
            query = "commit";
            statement.execute(query);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            win.setTitle("Voting System");
            win.setScene(scene);
            win.show();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



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