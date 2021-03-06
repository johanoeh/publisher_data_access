/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.xml;

import se.johan.oh.dataaccess.DBCreator;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import se.johan.oh.utils.FileReaderHandler;
import se.johan.oh.dataaccess.DBCreateorInterface;

/**
 * @author johan
 */
public class SaxParserHandler {
    
    SubjectXMLDataHandler xMLDataHandler;
    FileReaderHandler fileReaderHandler;
    SAXParserFactory sAXParserFactory;
    DBCreateorInterface dbInterface;
    String resource;
    SAXParser saxParser;
    
    /**
     * @param xmlFile
     */
    public SaxParserHandler(String xmlFile) throws SAXException, ParserConfigurationException, IOException{
        this.resource = xmlFile;
        fileReaderHandler = new FileReaderHandler(xmlFile);
        sAXParserFactory = SAXParserFactory.newInstance();
        saxParser = sAXParserFactory.newSAXParser();
        dbInterface = new DBCreator();
        xMLDataHandler = new SubjectXMLDataHandler(dbInterface);    
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
