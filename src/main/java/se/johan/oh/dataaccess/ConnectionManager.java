/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author johan
 */
public class ConnectionManager {

    private String driver;
    private String URL;
    private String password;
    private String userName;

    public ConnectionManager(String driver, String URL, String userName ,String password){
        this.driver = driver;
        this.URL = URL;
        this.userName = userName;
    }
    
    public  Connection getConnection(){
        Connection dbConnection = null;
        try {
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());

        }
        try {
            dbConnection = DriverManager.getConnection(URL, userName, password);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
    
}
