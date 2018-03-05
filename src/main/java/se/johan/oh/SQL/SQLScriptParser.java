package se.johan.oh.SQL;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author johan
 * parse slq file containing statements and executes the statements
 */
public class SQLScriptParser {

    private BufferedReader bufferedReader;
    private SQLExecutable executable;

    public SQLScriptParser(BufferedReader bufferedReader, SQLExecutable executable) {
        this.bufferedReader = bufferedReader;
        this.executable = executable;
    }

    /**
     * parses the buffered sql script
     */
    public void parse() {
        String line = null;
        String statement = "";
        try {
            while ((line = bufferedReader.readLine()) != null) {
                
                if(line.contains("/*") || line.contains("*") || line.contains("*/")) continue;
                
                if(line.contains(";")){
                    line = line.replace(";", "");
                    statement+=line;
                    executable.execute(statement);
                    statement ="";
                }else{
                    statement+=line+"\n";
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SQLScriptParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
