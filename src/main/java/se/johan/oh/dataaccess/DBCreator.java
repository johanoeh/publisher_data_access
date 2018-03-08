
package se.johan.oh.dataaccess;

import se.johan.oh.SQL.SQLScriptHandler;
import se.johan.oh.connection.ConnectionHandler;
import se.johan.oh.connection.ConnectionHandlerInterface;
import se.johan.oh.containers.*;
import static se.johan.oh.dataaccess.DataAccessFacade.SQL_FILE;



/**
 * @author johan
 */
public class DBCreator implements DBCreateorInterface {
  
    // variables to keep track of id of currently inserted rows
    private int currentSubjectID;
    private int currentQuizID;
    private int currentQuestionId;
    private  DataAccessInterface dao;
    private ConnectionHandlerInterface connectionHandler;
    
    /**
     *
     */
    public DBCreator() {
        connectionHandler = new ConnectionHandler(null);
        this.dao = new DataAccessFacade(connectionHandler);  
    }

    @Override
    public void createDB(String connectionString){
        System.err.println(connectionString);
        connectionHandler.setConnection(connectionString);
        SQLScriptHandler sQLScriptHandler = new SQLScriptHandler(SQL_FILE, connectionHandler);
        sQLScriptHandler.parse();
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

    /**
     *
     * @param userPerson
     */
    @Override
    public void create(UserPerson userPerson) {
        int userId = dao.create(userPerson.getUser());
        Person person = userPerson.getPerson();
        person.setUserID(userId);
        dao.create(person);  
    }
}
