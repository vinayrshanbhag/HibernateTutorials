package com.vinay.learning;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class main {

    public static void main(String[] args) {


        String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "hbstudent";
        String password= "hbstudent";

        try{
            System.out.println("Connecting to DataBase");
            Connection myConn = DriverManager.getConnection(url,user,password);
            System.out.println("Connection successful.!!!!!");
        }

        catch(Exception ex){

        }


    }
}
