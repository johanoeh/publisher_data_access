/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.SQL;

import java.io.BufferedReader;
import se.johan.oh.connection.ConnectionHandler;
import se.johan.oh.connection.ConnectionHandlerInterface;
import se.johan.oh.utils.FileReaderHandler;

/**
 *
 * @author johan
 */
public class SQLScriptHandler {

    private String scriptFile;
    private final SQLScriptParser sQLScriptParser;

    public SQLScriptHandler(String scriptFile, ConnectionHandlerInterface connectionHandler) {
        this.scriptFile = scriptFile;
        FileReaderHandler fileReaderHandler = new FileReaderHandler(scriptFile);
        BufferedReader bufferedReader
                = fileReaderHandler.getBufferedReader(scriptFile);
        sQLScriptParser = new SQLScriptParser(
                bufferedReader,
                new SQLExecutableIMPL(connectionHandler)
        );
    }
    
    public void parse(){
        sQLScriptParser.parse();
    }
}
