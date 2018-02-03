
package se.johan.oh.containers;

import java.io.Serializable;

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
    
    private String descriptionHTML;
    private String subjectName;
    private int subjectID;
    
    public Subject(){ this.subjectID = 0;}
    
    /**
     *
     * @param subjectName
     * @param descriptionHTM
     */
    public Subject(String subjectName, String descriptionHTM) {
        this.descriptionHTML = descriptionHTM;
        this.subjectName = subjectName;
    }
    
    /**
     *
     * @param subjectName
     * @param HTMLContent
     * @param subjectID
     */
    public Subject(String subjectName, String HTMLContent, int subjectID) {
        this.descriptionHTML = HTMLContent;
        this.subjectName = subjectName;
        this.subjectID = subjectID;
    }

    /**
     * @return the descriptionHTML
     */
    public String getDescriptionHTML() {
        return descriptionHTML;
    }

    /**
     * Sets the Description (intro) text for the subject use HTML formated string
     * @param descriptionHTML the descriptionHTML to set
     */
    public void setDescriptionHTML(String descriptionHTML) {
        this.descriptionHTML = descriptionHTML;
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
        
        return subjectName+"\n"+ descriptionHTML+ "\n"+subjectID+"\n";
    }
  
}