
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
    
    ConnectionHandlerInterface connectionHandler;
    UsersDataAccess(ConnectionHandlerInterface connectionHandler){
        this.connectionHandler = connectionHandler;
    }
    
    /**
     * @param user
     */
    public int create(User user){
        int id = -1;
        try (Connection connection = connectionHandler.getConnection()) {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(User.CREATE_USER_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }else {
            
            }
        } catch (SQLException exception) {
            System.err.println(exception);
        }
        return id;
    }
    
    /**
     *
     * @param userID
     */
    public void delete(int userID) {
        try (Connection connection = connectionHandler.getConnection()) {
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
        try (Connection connection = connectionHandler.getConnection()) {
           
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
        try(Connection conn = connectionHandler.getConnection()) {
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
        try(Connection conn = connectionHandler.getConnection()) {
           
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
