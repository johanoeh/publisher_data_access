/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.dataaccess;


import se.johan.oh.containers.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author johan
 */
public class UsersDataAccess {
    
    /**
     * @param user
     */
    public void create(User user){
        try (Connection connection = ConnectionHelper.getConnection()) {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(User.CREATE_USER_SQL);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.err.println(exception);
        }
    }
    
    /**
     *
     * @param userID
     */
    public void delete(int userID) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(User.DELETE_USER_SQL);
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            System.err.println(exception);
        }
    }
    
    /**
     * @param user
     */
    public void update(User user){
        try (Connection connection = ConnectionHelper.getConnection()) {
           
            PreparedStatement preparedStatement = 
                    connection.prepareStatement(User.UPDATE_USER_SQL);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setInt(3,user.getUserID());
            preparedStatement.executeUpdate();
        } catch(SQLException exception){
            System.err.println(exception);
        }
    }
    
    /**
     * @return
     */
    public List<User> readAll(){
        List<User> users = new ArrayList<>();
        try(Connection conn = ConnectionHelper.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(User.READ_ALL_USER_SQL);
            String [] columns = User.COLUMNS;
            while(rs.next()){
                User user = new User(
                        rs.getInt(columns[0]),
                        rs.getString(columns[1]), 
                        rs.getString(columns[2]));
                users.add(user);
            }
        } 
        catch(SQLException exception){
            System.err.println();
        }
        return users;
    }
    
    /**
     * @param userID
     * @return
     */
    public User read(int userID) {
       User user = null;
        try(Connection conn = ConnectionHelper.getConnection()) {
           
            PreparedStatement preparedStatement = conn.prepareStatement(User.READ_USER_SQL);
            preparedStatement.setInt(1, userID);
            ResultSet rs = preparedStatement.executeQuery();
            String [] columns = User.COLUMNS;
            if(rs.next()){
                user = new User(
                        rs.getInt(columns[0]),
                        rs.getString(columns[1]), 
                        rs.getString(columns[2]));   
            }
        } 
        catch(SQLException exception){
            System.err.println(exception);
        }
        return user;
    }
}