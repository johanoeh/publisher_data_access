
package se.johan.oh.containers;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author johan
 */
public class Subject implements Serializable{
    
    public static final String [] COLUMNS = {"SUBJECT_ID", "SUBJECT_NAME", "DESCRIPTION_HTML"};
    public static final String INSERT_SUBJECT_SQL = 
            "INSERT INTO SUBJECT (SUBJECT_NAME, DESCRIPTION_HTML) VALUES (?,?) ";
    public static final String SELECT_SUBJECTS_SQL = "SELECT SUBJECT_ID, SUBJECT_NAME, DESCRIPTION_HTML FROM SUBJECT";
    public static final String SELECT_SUBJECT_SQL = "SELECT SUBJECT_ID, SUBJECT_NAME, DESCRIPTION_HTML FROM SUBJECT WHERE SUBJECT_ID = ?";
    public static final String DELETE_SUBJECT_SQL = "DELETE FROM SUBJECT WHERE SUBJECT_ID = ?";

    public static final String DELETE_FROM_SUBJECT_HAS_CHAPTERS_SQL = "DELETE FROM SUBJECT_HAS_CHAPTERS WHERE SUBJECT_ID = ?";    
    public static final String SUBJECT_NAME = "SUBJECT_NAME";
    public static final String DESCRIPTION_HTML = "DESCRIPTION_HTML";
    public static final String SUBJECT_ID="SUBJECT_ID";
    
    protected String HTML;
    protected String subjectName;
    protected int subjectID;
    
    
    public Subject(){ 
        this.subjectID = 0;
    }



    /**
     * @param subjectName
     * @param HTML
     */
    public Subject(String subjectName, String HTML) {
        this.HTML = HTML;
        this.subjectName = subjectName;
        this.subjectID=0;
    }
    
    /**
     *
     * @param subjectName
     * @param HTMLContent
     * @param subjectID
     */
    public Subject(String subjectName, String HTMLContent, int subjectID) {
        this.HTML = HTMLContent;
        this.subjectName = subjectName;
        this.subjectID = subjectID;
    }
    
    /**
     * @return the HTML
     */
    public String getHTML() {
        return HTML;
    }

    /**
     * Sets the Description (intro) text for the subject use HTML formated string
     * @param HTML the HTML to set
     */
    public void setHTML(String HTML) {
        this.HTML = HTML;
    }

    /**
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }
    
    @Override
    public String toString(){
        return "Subject ID: "+ subjectID +" Subject name: "+ subjectName+" description HTML: "+ HTML;
    }
 
}
