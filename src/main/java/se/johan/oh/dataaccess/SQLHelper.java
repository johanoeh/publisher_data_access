/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johan
 */
public class SQLHelper {
    
    public static void delete(int id, String sql) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
