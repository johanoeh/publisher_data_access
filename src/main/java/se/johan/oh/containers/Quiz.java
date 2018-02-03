
package se.johan.oh.containers;

/**
 * @author johan
 */
public class Quiz {

    private int quizID;
    private int subjectID;
    private String quizName; 
    
    public static final String [] COLUMNS = {"QUIZ_ID","SUBJECT_ID","QUIZ_NAME"};
    
    public static final String CREATE_SQL = "INSERT INTO QUIZ (SUBJECT_ID, QUIZ_NAME) VALUES (?,?)";
    public static final String READ_BY_SUBJECT_ID_SQL   = "SELECT * FROM QUIZ WHERE SUBJECT_ID = ? " ;
    public static final String READ_BY_QUIZ_ID = "SELECT * FROM QUIZ WHERE QUIZ_ID = ?";
    public static final String READ_ALL_SQL = "SELECT * FROM QUIZ";
    public static final String UPDATE_SQL = "UPDATE QUIZ SET SUBJECT_ID = ?, QUIZ_NAME = ? WHERE QUIZ_ID = ?";
    public static final String DELETE_SQL = " DELETE FROM QUIZ WHERE QUIZ_ID = ?";
    public static final String DELETE_BY_SUBJECT_ID_SQL ="DELETE FROM QUIZ WHERE SUBJECT_ID = ?";

    public Quiz(int quizID, int subjectID, String quizName) {
        initQuiz(quizID, subjectID, quizName);
    }
    
    public void initQuiz(int quizID, int subjectID, String quizName) {
        this.quizID = quizID;
        this.subjectID = subjectID;
        this.quizName = quizName;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
    
    public String toString(){
        return COLUMNS[0]+" : "+quizID+", "+COLUMNS[1]+" : "+subjectID+", "+COLUMNS[2]+" : "+quizName;
    };  
}

