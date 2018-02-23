
package se.johan.oh.dataaccess;


import se.johan.oh.connection.ConnectionHandlerInterface;
import se.johan.oh.containers.Subject;
import se.johan.oh.containers.Chapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
public class SubjectDataAccess {
    
    private ChapterDataAccess chapterDAO;
    private ConnectionHandlerInterface connectionHandler;
    
    public SubjectDataAccess() {
        this.chapterDAO = new ChapterDataAccess(connectionHandler);
    }

    SubjectDataAccess(ConnectionHandlerInterface connectionHandler) {
        this.connectionHandler = connectionHandler;
    }
    
    
    /**
     * Returns a list of all subjects from db
     *
     * @return
     */
    public List<Subject> readAll() {
        List<Subject> subjects = new ArrayList<>();
        try (Connection connection = connectionHandler.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Subject.SELECT_SUBJECTS_SQL);
            while (resultSet.next()) {
                Subject subject = new Subject(
                        resultSet.getString(Subject.SUBJECT_NAME),
                        resultSet.getString(Subject.DESCRIPTION_HTML),
                        resultSet.getInt(Subject.SUBJECT_ID)
                );
                subjects.add(subject);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return subjects;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Subject read(int id){
        Subject subject = null;
        try (Connection connection = connectionHandler.getConnection()){
            PreparedStatement preparedStatement =  connection.prepareStatement(Subject.SELECT_SUBJECT_SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                    subject = new Subject(
                    resultSet.getString(Subject.SUBJECT_NAME),
                    resultSet.getString(Subject.DESCRIPTION_HTML), 
                    resultSet.getInt(Subject.SUBJECT_ID)
                    );
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return subject;
    }
    
    /**
     * Adds a new subject to db
     * @param subject to add
     * @return 
     */
    public int create(Subject subject) {
        int insertedKey = -1;
        try (Connection connection = connectionHandler.getConnection()) { 
            PreparedStatement preparedStatement
                    = connection.prepareStatement(Subject.INSERT_SUBJECT_SQL,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, subject.getSubjectName());
            preparedStatement.setString(2, subject.getDescriptionHTML());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next())
                insertedKey = resultSet.getInt(1);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return insertedKey;
    }
    
    /**
     * Deletes a subject and all it's related chapters
     * @param subjectID id of subject to delete
     */
    public void delete(int subjectID){
        try (Connection connection = connectionHandler.getConnection()){  
            List<Chapter> chapters = chapterDAO.readAll(subjectID);
            PreparedStatement preparedStatement = connection.prepareStatement(Subject.DELETE_FROM_SUBJECT_HAS_CHAPTERS_SQL);
            preparedStatement.setInt(1, subjectID);
            preparedStatement.executeUpdate();
            
            for (Chapter chapter : chapters) {
                chapterDAO.delete(chapter.getChapterID());
            }
            
            preparedStatement = connection.prepareStatement(Subject.DELETE_SUBJECT_SQL);
            preparedStatement.setInt(1, subjectID);

            preparedStatement.executeUpdate();
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }          
    }
}
