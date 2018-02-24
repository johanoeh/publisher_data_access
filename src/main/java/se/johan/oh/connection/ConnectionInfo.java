
package se.johan.oh.connection;

/**
 *
 * @author johan
 */
public class ConnectionInfo {
    
    
    private String DB_Name;
    private String URL;
    private String userName;
    private String passWord;

    public ConnectionInfo(String DB_Name, String URL, String userName, String passWord) {
        this.DB_Name = DB_Name;
        this.URL = URL;
        this.userName = userName;
        this.passWord = passWord;
    }

    /**
     * @return the DB_Name
     */
    public String getDB_Name() {
        return DB_Name;
    }

    /**
     * @param DB_Name the DB_Name to set
     */
    public void setDB_Name(String DB_Name) {
        this.DB_Name = DB_Name;
    }

    /**
     * @return the URL
     */
    public String getURL() {
        return URL;
    }

    /**
     * @param URL the URL to set
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the passWord
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * @param passWord the passWord to set
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
 
}
