package se.johan.oh.containers;

/**
 *
 * @author johan
 */
public class Answer {
    
    /* columns in table*/
    public static final String [] COLUMNS = {"ANSWER_ID","QUESTION_ID","ANSWER_TEXT","TRUTH_VALUE"};
    
    /* SQL queries used to manipulate  queries in db */
    public static final String CREATE_SQL ="INSERT INTO ANSWER (QUESTION_ID, ANSWER_TEXT, TRUTH_VALUE ) VALUES (?,?,?)";
    public static final String READ_BY_QUESTION_ID_SQL = "SELECT * FROM ANSWER WHERE QUESTION_ID = ?";
    public static final String UPDATE_SQL = "UPDATE TABLE ANSWER SET QUESTION_ID = ?, ANSWER_TEXT = ?, TRUTH_VALUE = ? WHERE ANSWER_ID = ?";
    public static final String DELETE_BY_ANSWER_ID_SQL = "DELETE FROM ANSWER WHERE ANSWER_ID = ?";
    public static final String DELETE_BY_QUESTION_ID = "DELETE FROM ANSWER WHERE QUESTION_ID = ? ";
    
    private int answerID;
    private int questionID;
    private String answerText;
    private Boolean truthValue;

   

    public Answer(int answerID, int questionID, String answerText, Boolean truthValue) {
        this.answerID = answerID;
        this.questionID = questionID;
        this.answerText = answerText;
        this.truthValue = truthValue;
    }

     public Boolean getTruthValue() {
        return truthValue;
    }

    public void setTruthValue(Boolean truthValue) {
        this.truthValue = truthValue;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
    
    public String toString(){
     return COLUMNS[0]+" : "+answerID+", "+COLUMNS[1]+" : "+questionID+", "+
            COLUMNS[2]+answerText+","+COLUMNS[3]+" : "+truthValue;
    }
}
