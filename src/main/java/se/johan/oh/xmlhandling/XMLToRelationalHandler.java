
package se.johan.oh.xmlhandling;

import se.johan.oh.containers.*;
import se.johan.oh.dataaccess.DataAccessFacade;
import se.johan.oh.dataaccess.DataAccessInterface;


/**
 * @author johan
 */
public class XMLToRelationalHandler implements XMLToRelationalInterface {
  
    private int currentSubjectID;
    private int currentQuizID;
    private int currentQuestionId;
    private final DataAccessInterface dao;
    private String dbName;
    
    public XMLToRelationalHandler(){
        dao = new DataAccessFacade();
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

    public void create(Person person) {
       dao.create(person);
    }

    public void create(User user) {
      dao.create(user);
    } 
}
