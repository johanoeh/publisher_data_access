/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.containers;

/**
 * @author johan
 */
public class User {
    
    private int userID;
    private String userName;
    private String password;
    
    public static final String [] COLUMNS = {"USER_ID","USER_NAME","PASSWORD"};
    public final static String CREATE_USER_SQL = "INSERT INTO USERS (USER_NAME, PASSWORD) VALUES ( ? , ?)";
    public final static String READ_USER_SQL = "SELECT * FROM USERS WHERE USER_ID = ?";
    public final static String READ_ALL_USER_SQL = "SELECT * FROM USERS";
    public final static String UPDATE_USER_SQL = "UPDATE USERS SET USER_NAME = ?, PASSWORD = ? WHERE USER_ID = ?";
    public final static String DELETE_USER_SQL = " DELETE FROM USERS WHERE USER_ID = ?";
   
    public User(int userID, String userName, String password) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toString(){
        return COLUMNS[0] + " : "+userID+", "+COLUMNS[1]+" : "+userName+", "+ COLUMNS[2]+" : "+ password;
    }
}
