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
public class ConnectionHandler implements ConnectionHandlerInterface {

    private final String driver;
    private final String URL;
    private final String password;
    private final String userName;
    
    private Connection dbConnection = null;
    
    private final static String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private final static String DB_CONNECTION = "jdbc:derby://localhost:1527/test;create=true";
    private final static String USER ="dbadmin";
    private final static String PASSWORD = "1234";
    

    /**
     *  The driver looks something like  org.apache.derby.jdbc.ClientDriver
     *  The connection URL "jdbc:derby://localhost:1527/test;create=true";
     * @param driver
     * @param connectionURL
     * @param userName
     * @param password
     */
    public ConnectionHandler(String driver, String connectionURL, String userName ,String password){
        this.driver = driver;
        this.URL = connectionURL;
        this.userName = userName;
        this.password = password;
    }
    
    public ConnectionHandler(){
        this.driver = DB_DRIVER;
        this.URL = DB_CONNECTION;
        this.userName = USER;
        this.password = PASSWORD;
    }
    
    @Override
    public  Connection getConnection(){
        
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
    
    @Override
   public void close(){
        try {
            dbConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
    @Override
   public void delete(int id, String sql) {
       Connection connection = getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}