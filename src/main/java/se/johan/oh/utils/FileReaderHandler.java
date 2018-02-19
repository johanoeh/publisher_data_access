/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author johan
 */
public class FileReaderHandler {
    
    String fileName;

    public FileReaderHandler(String fileName) {
        this.fileName = fileName;          
    }
    
    
    public BufferedReader getBufferedReaderV2(String resource){
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(resource);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        return bufferedReader;
    }
    
    public InputStream getInputStream(String resource){
         InputStream inputStream = this.getClass().
                 getClassLoader().getResourceAsStream(resource); 
         return inputStream;
    }

}
