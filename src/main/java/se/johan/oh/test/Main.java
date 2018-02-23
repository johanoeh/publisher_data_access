/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.test;


import java.io.IOException;
import java.sql.Connection;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import se.johan.oh.connection.ConnectionHandler;
import se.johan.oh.xml.SaxParserHandler;


/**
 *
 * @author johan
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws org.xml.sax.SAXException
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        
        String resource ="file/test.xml";
        SaxParserHandler parserHandler = new SaxParserHandler(resource);
        
        /*ConnectionHandler connectionManager = new ConnectionHandler(
                "org.apache.derby.jdbc.ClientDriver",
                "jdbc:derby://localhost:1527/test;create=true",
                "admin", 
                "1234");
        Connection connection = connectionManager.getConnection();*/
    }

}
