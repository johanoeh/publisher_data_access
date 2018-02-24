/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.xml;

import se.johan.oh.xml.utils.DB;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import se.johan.oh.dataaccess.DataAccessFacade;
import se.johan.oh.utils.FileReaderHandler;
import se.johan.oh.xml.utils.DBInterface;

/**
 * @author johan
 */
public class SaxParserHandler {
    
    SubjectXMLDataHandler xMLDataHandler;
    FileReaderHandler fileReaderHandler;
    SAXParserFactory sAXParserFactory;
    DBInterface dbInterface;
    String resource;
    SAXParser saxParser;
    
    /**
     * @param resource
     */
    public SaxParserHandler(String resource) throws SAXException, ParserConfigurationException, IOException{
        this.resource = resource;
        fileReaderHandler = new FileReaderHandler(resource);
        sAXParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = sAXParserFactory.newSAXParser();
        xMLDataHandler = new SubjectXMLDataHandler(new DB(new DataAccessFacade()));
        //saxParser.parse(fileReaderHandler.getInputStream(resource), xMLDataHandler);  
    }
    
    /**
     *
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public void parseXML() throws SAXException, IOException{
        saxParser.parse(fileReaderHandler.getInputStream(resource), xMLDataHandler);  
    }
   
}
