/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.dataaccess;

import java.sql.Connection;

/**
 *
 * @author johan
 */
public interface ConnectionHandlerInterface {
    void close();
    Connection getConnection();
    public void delete(int questionID, String DELETE_BY_QUESTION_ID);
}
