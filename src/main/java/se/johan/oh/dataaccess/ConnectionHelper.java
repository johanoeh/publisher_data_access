/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johan
 */
public class ConnectionHelper {
    
    private final static String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private final static String DB_CONNECTION = "jdbc:derby://localhost:1527/doa";
    private final static String USER ="dbadmin";
    private final static String PASSWORD = "1234";
    
    public static Connection getConnection(){
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());

        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, USER, PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
    
        public static void delete(int id,String sql){
         Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1,id);
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
