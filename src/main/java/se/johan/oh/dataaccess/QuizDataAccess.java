/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.dataaccess;

import se.johan.oh.containers.Quiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johan
 */
public class QuizDataAccess {

    public void create(Quiz quiz) {
        prepareAndUpdate(quiz, false, Quiz.CREATE_SQL);
    }

    public Quiz read(int quizID) {
        Quiz quiz = null;
        try (Connection connection = ConnectionHelper.getConnection()) {
            // Prepared statement used with parametirized SQL queries
            PreparedStatement prepareStatement
                    = connection.prepareStatement(Quiz.READ_BY_QUIZ_ID);
            prepareStatement.setInt(1, quizID);
            // execute the prepared query
            ResultSet rs = prepareStatement.executeQuery();
            // check if there is a result
            if (rs.next()) {
                quiz = new Quiz(
                        rs.getInt(Quiz.COLUMNS[0]),
                        rs.getInt(Quiz.COLUMNS[1]),
                        rs.getString(Quiz.COLUMNS[2])
                );
            }
        } catch (SQLException sQLException) {
            System.err.println(sQLException);
        }
        return quiz;
    }

    public List<Quiz> readBySubjectID(int subjectID) {

        List<Quiz> quizzes = new LinkedList<>();
        try (Connection connection = ConnectionHelper.getConnection()) {
            // Prepared statement used with parametirized SQL queries
            PreparedStatement prepareStatement
                    = connection.prepareStatement(Quiz.READ_BY_SUBJECT_ID_SQL);
            prepareStatement.setInt(1, subjectID);
            // execute the prepared query
            ResultSet rs = prepareStatement.executeQuery();
            // check if there is a result
            while (rs.next()) {
                Quiz quiz = new Quiz(
                        rs.getInt(Quiz.COLUMNS[0]),
                        rs.getInt(Quiz.COLUMNS[1]),
                        rs.getString(Quiz.COLUMNS[2])
                );
                quizzes.add(quiz);
            }
        } catch (SQLException sQLException) {
            System.err.println(sQLException);
        }
        return quizzes;
    }

    public void update(Quiz quiz) {
        prepareAndUpdate(quiz, true, Quiz.UPDATE_SQL);
    }

    public void delete(int quizID) {
        ConnectionHelper.delete(quizID, Quiz.DELETE_BY_SUBJECT_ID_SQL);
    }

    public void deleteBySubjectID(int subjectID) {
        ConnectionHelper.delete(subjectID, Quiz.DELETE_BY_SUBJECT_ID_SQL);
    }

    private void prepareAndUpdate(Quiz quiz, boolean isUpdate, String sql) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            PreparedStatement prepareStatement;
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, quiz.getSubjectID());
            prepareStatement.setString(2, quiz.getQuizName());
            if (isUpdate) {
                prepareStatement.setInt(3, quiz.getQuizID());
            }
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
