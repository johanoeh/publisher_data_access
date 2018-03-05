package se.johan.oh.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.johan.oh.dataaccess.QuizDataAccess;

/**
 *
 * @author johan
 */
public class ConnectionHandler implements ConnectionHandlerInterface {

    private  String driver;
    private  String URL;
    private  String dbName;
    private  String password;
    private  String userName;
    
    private Connection dbConnection = null;  
    private final static String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    //private final static String DB_CONNECTION = "jdbc:derby://localhost:1527/test;create=true";
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
    /*
    public ConnectionHandler(){
        this.driver = DB_DRIVER;
        this.URL = DB_CONNECTION;
        this.userName = USER;
        this.password = PASSWORD;
    }*/
    
    public ConnectionHandler(String connectionString){
        this.URL = connectionString;
        driver = DB_DRIVER;
    }
    
    @Override
    public  Connection getConnection(){
        
        try {
            Class.forName(driver);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {    
            dbConnection = DriverManager.getConnection(URL);
            return dbConnection;
        } catch (SQLException ex) {
              Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
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
