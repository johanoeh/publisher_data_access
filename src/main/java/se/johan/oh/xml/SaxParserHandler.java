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
    
    /**
     * @param resource
     */
    public SaxParserHandler(String resource) throws SAXException, ParserConfigurationException, IOException{
        DBInterface dbInterface = new DB(new DataAccessFacade());
        fileReaderHandler = new FileReaderHandler(resource);
        sAXParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = sAXParserFactory.newSAXParser();
        xMLDataHandler = new SubjectXMLDataHandler(dbInterface);
        saxParser.parse(fileReaderHandler.getInputStream(resource), xMLDataHandler);  
    }
    
    /**
     *
     */
    public void parseXML(){

    }
   
}
