/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.xmlhandling;

import java.util.List;
import java.util.Map;
import se.johan.oh.xmlparsing.XMLcontainers.SimpleXMLElement;

/**
 *
 * @author johan
 */
public class XMLStringHandler {

    public static String build(List<SimpleXMLElement> elements){
        String xmlString="";
        for (SimpleXMLElement element : elements) {
             xmlString+=build(element);
        }
        return xmlString;
    }
    
    /**
     *
     * @param element
     * @return
     */
    public static String build(SimpleXMLElement element) {
        String xmlString = "";
        xmlString += "<" + element.getTagName();
        Map<String, String> attributes = element.getAttributes();
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            xmlString += " " + key + " = \"" + value + "\"";
        }
        xmlString += ">";
        List<String> content = element.getContent();
        for (String string : content) {
            xmlString += string;
        }
        xmlString+="</"+element.getTagName()+">";
        
        return xmlString;
    }
    
    /**
     * builds an xml string of the child elements of SimpleXMLElement
     * @param element
     * @return
     */
    public static String childContentBuild(SimpleXMLElement element) {
        String xmlString = "";
        List<String> content = element.getContent();
        for (String string : content) {
            xmlString += string;
        }
        return xmlString;
    }
    
}
