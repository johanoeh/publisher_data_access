
package se.johan.oh.containers;

import java.util.LinkedList;
import java.util.List;

/**
 * @author johan
 */
public class Question {
    
    public static final String [] COLUMNS = {"QUESTION_ID","QUIZ_ID", "QUESTION_TEXT"};
    
    /* SQL queries used to manipulate a Question object in db*/
    public static final String CREATE_SQL = "INSERT INTO QUESTION (QUIZ_ID, QUESTION_TEXT) VALUES (?,?)";
    public static final String READ_BY_QUIZ_ID_SQL = "SELECT * FROM QUESTION WHERE QUIZ_ID = ?";
    public static final String UPDATE_SQL = "UPDATE QUESTION SET QUIZ_ID=?, QUESTION_TEXT = ? WHERE QUIZ_ID = ?";
    public static final String DELETE_BY_QUIZ_ID_SQL = "DELETE FROM QUESTION WHERE QUIZ_ID = ?";
    public static final String DELETE_BY_QUESTION_ID_SQL ="DELETE FROM QUESTION WHERE QUESTION_ID = ?";

    private int QuestionID;
    private int quizID;
    private String questionText;
    
    private List<Answer> answers;

    public Question(int QuestionID, int quizID, String questionText) {
        initQuestion(QuestionID, quizID, questionText);
        answers = new LinkedList<>();
    }

    public Question() {
        answers = new LinkedList<>();
    }
    
   
    public void initQuestion(int QuestionID, int quizID, String questionText) {
        this.QuestionID = QuestionID;
        this.quizID = quizID;
        this.questionText = questionText;
    }
    
    public void addAnswer(Answer answer){
        answers.add(answer);
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    /**
     * @return the QuestionID
     */
    public int getQuestionID() {
        return QuestionID;
    }

    /**
     * @param QuestionID the QuestionID to set
     */
    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    /**
     * @return the quizID
     */
    public int getQuizID() {
        return quizID;
    }

    /**
     * @param quizID the quizID to set
     */
    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    /**
     * @return the questionText
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * @param questionText the questionText to set
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    
    public String toString(){
        return COLUMNS[0]+" : "+QuestionID+", "+COLUMNS[1]+" : "+quizID+", "+COLUMNS[2]+" : "+questionText;
    }
}
