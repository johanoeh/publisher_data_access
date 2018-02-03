
package se.johan.oh.dataaccess;


import se.johan.oh.containers.Question;
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
public class QuestionDataAccess {
    
    
    public void create(Question question) {
        prepareUpdate(question, Question.CREATE_SQL, false); 
    }
    
    /**
     * @param quizID
     * @return
     * @throws java.sql.SQLException
     */
    public List<Question> readByQuizID(int quizID){
        List<Question> questions = new LinkedList<>();
        try (Connection connection = ConnectionHelper.getConnection()) {
            PreparedStatement prepareStatement = connection.prepareStatement(Question.READ_BY_QUIZ_ID_SQL);
            prepareStatement.setInt(1, quizID);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                parseResultset(question, rs);
                questions.add(question);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }
    
    private void parseResultset(Question question, ResultSet rs) throws SQLException {
        question.initQuestion(
                rs.getInt(Question.COLUMNS[0]),
                rs.getInt(Question.COLUMNS[1]),
                rs.getString(Question.COLUMNS[2])
        );
    }
    
    private void prepareUpdate(Question question, String sql, boolean isUpdate){
        try (Connection connection = ConnectionHelper.getConnection()) {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, question.getQuizID());
            prepareStatement.setString(2, question.getQuestionText());
            if (isUpdate) {
                prepareStatement.setInt(3, question.getQuestionID());
            }
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void update(Question question) {
        prepareUpdate(question, Question.UPDATE_SQL, true);
    }
    
    void deleteByQuizID(int quizID) throws SQLException {
        try (Connection connection = ConnectionHelper.getConnection()) {
            PreparedStatement prepareStatement = connection.prepareStatement(Question.DELETE_BY_QUIZ_ID_SQL);
            prepareStatement.setInt(1, quizID);
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void deleteByQuestionID(int questionID) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            PreparedStatement prepareStatement = connection.prepareStatement(Question.DELETE_BY_QUESTION_ID_SQL);
            prepareStatement.setInt(1, questionID);
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
