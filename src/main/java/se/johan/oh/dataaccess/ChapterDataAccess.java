
package se.johan.oh.dataaccess;

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
public class ChapterDataAccess {
    
    ConnectionHandlerInterface connectionHandler;
    
    
    public ChapterDataAccess(ConnectionHandlerInterface connectionHandler){
        this.connectionHandler = connectionHandler;
    }
    
    /**
     * @param chapter to add
     * @return  key of inserted value
     */
    public int create(Chapter chapter) {
        int insertedKey = -1;
        try (Connection connection = connectionHandler.getConnection()) {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(Chapter.INSERT_CHAPTER_SQL,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,chapter.getSubjectID());
            preparedStatement.setString(2, chapter.getChapterName());
            preparedStatement.setInt(3, chapter.getPriority());
            preparedStatement.setString(4, chapter.getContentHTML());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next())
                insertedKey = rs.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return insertedKey;
    }
    
    /**
     * Returns a chapter based on it's id
     *
     * @param chapterID
     * @return
     */
    public Chapter read(int chapterID){
        Chapter chapter = null;
        try (Connection connection = connectionHandler.getConnection();) {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(Chapter.SELECT_CHAPTER_SQL);
            preparedStatement.setInt(1, chapterID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                chapter = new Chapter(resultSet.getInt(Chapter.CHAPTER_ID),
                        resultSet.getInt(Chapter.SUBJECT_ID),
                        resultSet.getString(Chapter.CHAPTER_NAME),
                        resultSet.getInt(Chapter.PRIORITY),
                        resultSet.getString(Chapter.HTML_CONTENT));
            }
        } catch(SQLException ex){
             System.err.println(ex.getMessage());
        }

        return chapter;
    }
    
    /**
     * returns all chapters related to a specified subject
     * @param subjectID
     * @return
     */
    public List<Chapter> readAll(int subjectID) {
        List<Chapter> chapters = new ArrayList<>();
        try (Connection connection = connectionHandler.getConnection();) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Chapter.SELECT_ALL_CHAPTERS_SQL);
            while (resultSet.next()) {
                Chapter chapter = new Chapter(resultSet.getInt(Chapter.CHAPTER_ID),
                        resultSet.getInt(Chapter.SUBJECT_ID),
                        resultSet.getString(Chapter.CHAPTER_NAME),
                        resultSet.getInt(Chapter.PRIORITY),
                        resultSet.getString(Chapter.HTML_CONTENT));
                chapters.add(chapter);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return chapters;
    }
    
    
    /**
     * Updates the chapter with the specified ID
     *
     * @param chapterID
     * @param chapter
     */
    public void update(int chapterID, Chapter chapter) {
        try (Connection connection = connectionHandler.getConnection()) {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(Chapter.UPDATE_CHAPTER_SQL);
            preparedStatement.setString(1, chapter.getChapterName());
            preparedStatement.setInt(2, chapter.getPriority());
            preparedStatement.setString(3, chapter.getContentHTML());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    } 
    
    /**
     * Deletes chapter with the specified ID.
     * @param chapterID
     */
    public void delete(int chapterID){
        connectionHandler.delete(chapterID, Chapter.DELETE_CHAPTER_SQL);
    }
  
}
