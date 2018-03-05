
package se.johan.oh.xml.utils;


import se.johan.oh.connection.ConnectionHandler;
import se.johan.oh.containers.*;
import se.johan.oh.dataaccess.DataAccessFacade;
import se.johan.oh.dataaccess.DataAccessInterface;


/**
 * @author johan
 */
public class DB implements DBInterface {
  
    private int currentSubjectID;
    private int currentQuizID;
    private int currentQuestionId;
    private  DataAccessInterface dao;
    private String connectionString;
    

    public DB(DataAccessInterface dataAccessInterface) {
        this.dao = dataAccessInterface;
    }
    
    public DB(){}

    @Override
    public void createDB(String connectionString){
        this.dao = new DataAccessFacade();
        this.connectionString = connectionString;
        dao.createDB(connectionString);
    }
    
    @Override
    public String getDBName(){
        return connectionString;
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
        int create = dao.create(user);
    } 

    @Override
    public void create(UserPerson userPerson) {
        int userId = dao.create(userPerson.getUser());
        Person person = userPerson.getPerson();
        person.setUserID(userId);
        dao.create(person);  
    }
}
