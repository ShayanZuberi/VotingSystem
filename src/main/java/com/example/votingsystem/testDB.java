package com.example.votingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testDB {
    public static void main(String argz[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "12345");
            System.out.println("Connection Established!");
            Statement statement = con.createStatement();
            int id = 1;
            String query = "INSERT into votingsystem.citizen values(" + id + ")";
           // statement.executeQuery(query);
            statement.execute(query);
            query = "commit";
            // statement.executeQuery(query);
            statement.execute(query);
            //rs.next();
            //int count = rs.getInt(1);
            //System.out.println("COUNT: " + count);

        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }


    }
}
