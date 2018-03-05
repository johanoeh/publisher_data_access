
package se.johan.oh.SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.johan.oh.connection.ConnectionHandlerInterface;

/**
 * @author johan
 */
public class SQLExecutableIMPL implements SQLExecutable {

   private ConnectionHandlerInterface connectionHandler;
   public SQLExecutableIMPL(ConnectionHandlerInterface connectionHandler){
       this.connectionHandler = connectionHandler;
   }
    @Override
   public void execute(String sql){
       try {
           Connection connection = connectionHandler.getConnection();
           Statement statement = connection.createStatement();
           statement.execute(sql);
       } catch (SQLException ex) {
           Logger.getLogger(SQLExecutableIMPL.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
