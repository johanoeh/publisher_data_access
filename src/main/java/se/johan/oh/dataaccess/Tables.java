/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.dataaccess;

/**
 *
 * @author johan
 */
public class Tables {
    
    public static String SUBJECT_TABLE ="CREATE TABLE SUBJECT (\n" +
"    SUBJECT_ID  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),  \n" +
"    SUBJECT_NAME VARCHAR(100) NOT NULL,\n" +
"    DESCRIPTION_HTML LONG VARCHAR NOT NULL,\n" +
"    PRIMARY KEY (SUBJECT_ID)\n" +
")";
    
}
