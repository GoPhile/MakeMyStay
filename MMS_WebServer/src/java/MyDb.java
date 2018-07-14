/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csrua
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDb {
    public Connection con;
    public Connection getCon(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con =  DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/makemystay?autoReconnect=true"
                    + "&useSSL=false", "root", 
                    "The demon lived at Mach 1 on the meter");
        System.out.println("Database found!");
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Database not found!");

    }
        // TODO Auto-generated catch block
    return con;
}
}