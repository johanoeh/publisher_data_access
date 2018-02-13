/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.xmlparsing;
import java.util.Enumeration;
import java.util.Hashtable;
import jdk.internal.org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author johan
 */
public class parser  extends DefaultHandler {
    private Hashtable tags;
    
    @Override
    public void startDocument() throws SAXException {
        tags = new Hashtable();
    
    }
    
    public void startElement(
            
            String namespaceURI,
            String localName,
            String qName,
            Attributes atts
            
    ) throws SAXException {

    String key = localName;
    Object value = tags.get(key);

    if (value == null) {
        tags.put(key, new Integer(1));
    } 
    else {
        int count = ((Integer)value).intValue();
        count++;
        tags.put(key, new Integer(count));
    }
}
    
    @Override
     public void endDocument() throws SAXException {
        Enumeration e = tags.keys();
        while (e.hasMoreElements()) {
            String tag = (String)e.nextElement();
            int count = ((Integer)tags.get(tag)).intValue();
            System.out.println("Local Name \"" + tag + "\" occurs " 
                               + count + " times");
        }    
    }
}
