
package se.johan.oh.xml.utils;


import se.johan.oh.containers.*;
import se.johan.oh.dataaccess.DataAccessInterface;


/**
 * @author johan
 */
public class DB implements DBInterface {
  
    private int currentSubjectID;
    private int currentQuizID;
    private int currentQuestionId;
    private final DataAccessInterface dao;
    private String dbName;
    

    public DB(DataAccessInterface dataAccessInterface) {
        this.dao = dataAccessInterface;
    }

    @Override
    public void createDB(String dbName){
        this.dbName = dbName;
        dao.createDB(dbName);
    }
    
    @Override
    public String getDBName(){
        return dbName;
    }

    /**
     * @param subject
     */
    @Override
    public void create(Subject subject){
        currentSubjectID  = dao.create(subject);
    }
    
    /**
     * @param chapter
     */
    @Override
    public void create(Chapter chapter){
        chapter.setSubjectID(currentSubjectID);
        dao.create(chapter);
    }
    
    /**
     * @param quiz the quiz to add
     */
    @Override
    public void create(Quiz quiz){
        quiz.setSubjectID(currentSubjectID);
        currentQuizID = dao.create(quiz);
    }
    
    /**
     *
     * @param question
     */
    @Override
    public void create(Question question){
        question.setQuizID(currentQuizID);
        currentQuestionId = dao.createQuestion(question);
    }
    
    /**
     * @param answer
     */
    @Override
    public void create(Answer answer){
        answer.setQuestionID(currentQuestionId);
        dao.create(answer);
    }

    /**
     *
     * @param person
     */
    @Override
    public void create(Person person) {
       dao.create(person);
    }

    /**
     *
     * @param user
     */
    @Override
    public void create(User user) {
      dao.create(user);
    } 
}
