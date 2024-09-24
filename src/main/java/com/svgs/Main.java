package com.svgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:./src/main/resources/chinook.db";
        try{
            Connection conn = DriverManager.getConnection(url);
            Statement state = conn.createStatement();
            String query = "SELECT * FROM employees ORDER BY FirstName ASC";
            ResultSet results = state.executeQuery(query);
            while(results.next()){
                String first = results.getString("FirstName");
                System.out.println(first);
            }

            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}