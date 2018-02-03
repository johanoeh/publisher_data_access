/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
  
    /**
     * @param chapter to add
     * @param subjectID the id of subject chapter belongs to
     */
    public void create(Chapter chapter, int subjectID) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(Chapter.INSERT_CHAPTER_SQL,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, chapter.getChapterName());
            preparedStatement.setInt(2, chapter.getPriority());
            preparedStatement.setString(3, chapter.getContentHTML());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                int insertedKey = resultSet.getInt(1);
                preparedStatement = connection.prepareStatement(Chapter.INSERT_SUBJECT_HAS_CHAPTERS_SQL);
                preparedStatement.setInt(1, subjectID);
                preparedStatement.setInt(2, insertedKey);
                preparedStatement.executeUpdate();
            } 
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    /**
     * Returns a chapter based on it's id
     *
     * @param chapterID
     * @return
     */
    public Chapter read(int chapterID){
        Chapter chapter = null;
        try (Connection connection = ConnectionHelper.getConnection();) {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(Chapter.SELECT_CHAPTER_SQL);
            preparedStatement.setInt(1, chapterID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                chapter = new Chapter(resultSet.getInt(Chapter.CHAPTER_ID),
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
        try (Connection connection = ConnectionHelper.getConnection();) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Chapter.SELECT_ALL_CHAPTERS_SQL);
            while (resultSet.next()) {
                Chapter chapter = new Chapter(resultSet.getInt(Chapter.CHAPTER_ID),
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
        try (Connection connection = ConnectionHelper.getConnection()) {
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
        ConnectionHelper.delete(chapterID, Chapter.DELETE_CHAPTER_SQL);
    }

    
}