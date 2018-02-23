/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.xml.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author johan
 */
public class SimpleXMLElement {
    
    String tagName;
    List<String> content;
    Map<String, String> attributes;
    public static final int INCLUDE_CONTENT_ONLY = 0;
    public static final int INCLUDE_WRAPPING_ELEMENT = 1;
    
    public SimpleXMLElement(String tagName){
        content = new LinkedList<>();
        attributes = new HashMap<>();
        this.tagName = tagName;
    }
    
    public void append(String str){
        content.add(str);
    }
    
    public void appendStartTag(String str){
         content.add("<"+str+">");
    }
    
    public void appendEndTag(String str){
         content.add("</"+str+">");
    }
    
    public void appendAttribute(String Name,String value){
        attributes.put(Name, value);
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
    
    public String toString(){
        String xmlString = "";
        for (String string : content) {
            xmlString+=string;
        }
        return xmlString;
    }
}
