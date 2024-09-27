package com.svgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Main {

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        createDatabase();
        menu();
    }

    public static void createDatabase() {
        String url = "jdbc:sqlite:./src/main/resources/users.db";
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS users(userId TEXT, password TEXT, role TEXT)";
            statement.executeUpdate(query);
        } catch (SQLException error) {
            System.out.println("An error occured.");
            System.out.println(error);
        }
    }
    public static void menu(){
        System.out.println("1. Create a user");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if(choice.equals("1")){
            System.out.print("Username: ");
            String username = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();
            System.out.print("Role: ");
            String role = input.nextLine();
            createUser(username, password, role);
        }
    }
    public static void createUser(String tempUsername, String tempPassword, String tempRole){

    }
}