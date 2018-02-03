
package se.johan.oh.dataaccess;

import se.johan.oh.containers.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author johan
 */
public class AnswerDataAccess {
    
    /**
     * @param answer
     */
    public void create(Answer answer) {
        prepareUpdate(answer, Answer.CREATE_SQL, Boolean.FALSE);
    }
    
    /**
     * @param questionID
     * @return
     */
    public List<Answer> readByQuestionID(int questionID){
        List<Answer> answers = new LinkedList<>();
        try (Connection connection = ConnectionHelper.getConnection()) {
            // Prepared statement used with parametirized SQL queries
            PreparedStatement prepareStatement
                    = connection.prepareStatement(Answer.READ_BY_QUESTION_ID_SQL);
            prepareStatement.setInt(1,questionID);
            // execute the prepared query
            ResultSet rs = prepareStatement.executeQuery();
            // iterate results if any
            while (rs.next()) {
                Answer answer = new Answer(
                        rs.getInt(Answer.COLUMNS[0]), 
                        rs.getInt(Answer.COLUMNS[1]),
                        rs.getString(Answer.COLUMNS[2]), 
                        rs.getBoolean(Answer.COLUMNS[3])
                );
                answers.add(answer);
            }
        } catch (SQLException sQLException) {
            System.err.println(sQLException);
        }
        return answers;
    }
    
    /**
     *
     * @param answer
     */
    public void update(Answer answer) {
        prepareUpdate(answer, Answer.UPDATE_SQL, true);
    }
    
    /**
     *
     * @param questionID
     */
    public void deleteByQuestionID(int questionID){
        ConnectionHelper.delete(questionID, Answer.DELETE_BY_QUESTION_ID);
    }
    
    /**
     * @param answerID
     */
    public void deletetByID(int answerID){
        ConnectionHelper.delete(answerID, Answer.DELETE_BY_ANSWER_ID_SQL);
    }
    
    private void prepareUpdate(Answer answer, String sql, boolean isUpdate) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            PreparedStatement prepareStatement
                    = connection.prepareStatement(sql);
            prepareStatement.setInt(1, answer.getQuestionID());
            prepareStatement.setString(2, answer.getAnswerText());
            prepareStatement.setBoolean(3, answer.getTruthValue());
            if (isUpdate) {
                prepareStatement.setInt(4, answer.getAnswerID());
            }
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
