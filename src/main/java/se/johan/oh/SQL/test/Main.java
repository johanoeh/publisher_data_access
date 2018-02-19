/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.SQL.test;

import java.io.BufferedReader;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import se.johan.oh.utils.FileReaderHandler;
import se.johan.oh.xmlparsing.ParserHandler;

/**
 *
 * @author johan
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException{
    String resource ="file/test.xml";
    ParserHandler parserHandler = new ParserHandler(resource);
    }

}
