/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import se.johan.oh.SQL.SQLExecutableIMPL;
import se.johan.oh.SQL.SQLScriptParser;
import se.johan.oh.connection.ConnectionHandler;

import se.johan.oh.dataaccess.Tables;
import se.johan.oh.utils.FileReaderHandler;
import se.johan.oh.xml.SaxParserHandler;


/**
 *
 * @author johan
 */
public class Main {

    private static final  String URL ="jdbc:derby://localhost:1527/";
    private static final  String USER_NAME ="admin";
    private static final  String PASSWORD="1234";
    /**
     * @param args the command line arguments
     * @throws org.xml.sax.SAXException
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException, SQLException {
        
        String resource ="file/test.xml";
        SaxParserHandler parserHandler = new SaxParserHandler(resource);
        parserHandler.parseXML();
        
    }
    
}
