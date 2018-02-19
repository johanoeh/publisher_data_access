/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.xmlparsing;

import java.io.BufferedReader;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import se.johan.oh.utils.FileReaderHandler;

/**
 * @author johan
 */
public class ParserHandler {
    
    XMLDataHandler xMLDataHandler;
    FileReaderHandler fileReaderHandler;
    SAXParserFactory sAXParserFactory;
    
    /**
     * @param resource
     */
    public ParserHandler(String resource) throws SAXException, ParserConfigurationException, IOException{
        fileReaderHandler = new FileReaderHandler(resource);
        sAXParserFactory = SAXParserFactory.newInstance();
        SAXParser sp = sAXParserFactory.newSAXParser();
        xMLDataHandler = new XMLDataHandler();
        sp.parse(fileReaderHandler.getInputStream(resource), xMLDataHandler);
    }
    
    /**
     *
     */
    public void parseXML(){
        
    
    }
   
}
