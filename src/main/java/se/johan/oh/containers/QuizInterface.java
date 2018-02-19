/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.containers;

/**
 *
 * @author johan
 */
public interface QuizInterface {

    public static final String[] COLUMNS = {"QUIZ_ID", "SUBJECT_ID", "QUIZ_NAME"};
    public static final String CREATE_SQL = "INSERT INTO QUIZ (SUBJECT_ID, QUIZ_NAME) VALUES (?,?)";
    public static final String DELETE_BY_SUBJECT_ID_SQL = "DELETE FROM QUIZ WHERE SUBJECT_ID = ?";
    public static final String DELETE_SQL = " DELETE FROM QUIZ WHERE QUIZ_ID = ?";
    public static final String READ_ALL_SQL = "SELECT * FROM QUIZ";
    public static final String READ_BY_QUIZ_ID = "SELECT * FROM QUIZ WHERE QUIZ_ID = ?";
    public static final String READ_BY_SUBJECT_ID_SQL = "SELECT * FROM QUIZ WHERE SUBJECT_ID = ? ";
    public static final String UPDATE_SQL = "UPDATE QUIZ SET SUBJECT_ID = ?, QUIZ_NAME = ? WHERE QUIZ_ID = ?";

    int getQuizID();

    String getQuizName();

    int getSubjectID();

    void initQuiz(int quizID, int subjectID, String quizName);

    void setQuizID(int quizID);

    void setQuizName(String quizName);

    void setSubjectID(int subjectID);

    @Override
    String toString();
    
}
