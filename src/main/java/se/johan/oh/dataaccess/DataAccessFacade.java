
package se.johan.oh.dataaccess;


import se.johan.oh.connection.ConnectionHandler;
import se.johan.oh.connection.ConnectionHandlerInterface;
import se.johan.oh.containers.Answer;
import se.johan.oh.containers.Subject;
import se.johan.oh.containers.Chapter;
import se.johan.oh.containers.Person;
import se.johan.oh.containers.Question;
import se.johan.oh.containers.Quiz;
import se.johan.oh.containers.User;
import java.util.List;
import se.johan.oh.SQL.SQLScriptHandler;


/**
 * @author johan
 */
public class DataAccessFacade implements DataAccessInterface {

    private SubjectDataAccess subjectDAO;
    private ChapterDataAccess chapterDAO;
    private UsersDataAccess userDAO;
    private PersonDataAccess personDAO;
    private QuizDataAccess quizDAO;
    private QuestionDataAccess questionDAO;
    private AnswerDataAccess answerDAO;
    private ConnectionHandlerInterface connectionHandler;
    public static final String SQL_FILE ="file/publish_sql.sql";
    
    public DataAccessFacade(ConnectionHandlerInterface connectionHandler){
        this.connectionHandler = connectionHandler;
        setConnectionHandler(connectionHandler);
    }
    private void setConnectionHandler(ConnectionHandlerInterface connectionHandler) {
        this.connectionHandler = connectionHandler;
        subjectDAO = new SubjectDataAccess(connectionHandler);
        chapterDAO = new ChapterDataAccess(connectionHandler);
        userDAO = new UsersDataAccess(connectionHandler);
        personDAO = new PersonDataAccess(connectionHandler);
        quizDAO = new QuizDataAccess(connectionHandler);
        questionDAO = new QuestionDataAccess(connectionHandler);
        answerDAO = new AnswerDataAccess(connectionHandler);
    }

    
    /* Access methods for subjects -------------------------------------------*/
    
    /**
     * Returns a list of all subjects from db
     * @return
     */
    @Override
    public List<Subject> readAllSubjects() {
        return subjectDAO.readAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Subject readSubject(int id) {
        return subjectDAO.read(id);
    }

    /**
     * Adds a new subject to db
     *
     * @param subject to add
     * @return 
     */
    @Override
    public int create(Subject subject) {
        return subjectDAO.create(subject);
    }

    /**
     * Deletes a subject and all it's related chapters
     *
     * @param subjectID id of subject to delete
     */
    @Override
    public void deleteSubject(int subjectID) {
        subjectDAO.delete(subjectID);
    }

    
    /*Access methods for chapters --------------------------------------------*/
    
    /**
     * @param chapter to add
     * @return 
     */
    @Override
    public int create(Chapter chapter) {
        return chapterDAO.create(chapter);
    }

    @Override
    public Chapter readChapter(int chapterID) {
        return chapterDAO.read(chapterID);
    }
  
    /**
     *
     * @param subjectID
     * @return
     */
    @Override
    public List<Chapter> readAllChapters(int subjectID) {
        return chapterDAO.readAll(subjectID);
    }

    /**
     *
     * @param chapterID
     */
    @Override
    public void deleteChapter(int chapterID) {
        chapterDAO.delete(chapterID);
    }

    /**
     *
     * @param chapterID
     * @param chapter
     */
    @Override
    public void updateChapter(int chapterID, Chapter chapter) {
        chapterDAO.update(chapterID, chapter);
    }
    
    
    /* Access methods for users-----------------------------------------------*/

    /**
     * @param user
     */
    @Override
    public int create(User user){
        return userDAO.create(user);
    }
    
    /**
     * @param userID
     */
    @Override
    public void deleteUser(int userID){
     userDAO.delete(userID);
    }
    
    /**
     *
     * @param user
     */
    @Override
    public void updateUser(User user){
        userDAO.update(user);
    }
    
    /**
     *
     * @param userID
     * @return
     */
    @Override
    public User readUser(int userID){
        return userDAO.read(userID);
    }
    
    /**
     * @return
     */
    @Override
    public List<User> readAllusers(){
        return userDAO.readAll();
    }
    
    /*Access methods for Person ---------------------------------------------*/
    @Override
    public int create(Person person){
       return personDAO.create(person);
    }
    
    @Override
    public Person readPerson(int userID){
        return personDAO.read(userID);
    }
    
    @Override
    public List<Person> readAllPersons(){
        return personDAO.readAll();
    }
    
    
    @Override
    public void updatePerson(Person person){
        personDAO.update(person);
    }

    @Override
    public void deletePerson(Integer id) {
       personDAO.delete(id);
    }
    
    /*Access methods for quizzes----------------------------------------------*/
    @Override
    public int create(Quiz quiz){
       return quizDAO.create(quiz);
    }
    
    @Override
    public List<Quiz> readQuiz(int subjectID){
        return quizDAO.readBySubjectID(subjectID);
    }
    
    @Override
    public void update(Quiz quiz){
        quizDAO.update(quiz);
    }

    
    @Override
    public void deleteQuiz(int quizID){
      quizDAO.delete(quizID);
    }
    
    @Override
    public void deleteQuizBySubjectID(int SubjectID){
        quizDAO.deleteBySubjectID(SubjectID);
    }
    
    /* Access methods for Questions ------------------------------------------*/
    
    @Override
    public int create(Question question){
        return questionDAO.create(question);
    }
    
    @Override
    public List<Question> readQuestions(int quizID){
        return questionDAO.readByQuizID(quizID);
    }
    
    @Override
    public void update(Question question){
        questionDAO.update(question);
    }

    @Override
    public void deleteByQuestionID(int questionID) {
        questionDAO.deleteByQuestionID(questionID);
    }
    
    /* Access methods for answers --------------------------------------------*/  
    @Override
    public int create(Answer answer){
        return answerDAO.create(answer);
    }
    
    @Override
    public List<Answer> readAnswerByQuestionID(int questionID){
        return answerDAO.readByQuestionID(questionID);
    }
    
    @Override
    public void update(Answer answer){
        answerDAO.update(answer);
    }
    
    @Override
    public void deleteAnswer( int answerID){
        answerDAO.deletetByID(answerID);
    }
    
    @Override
     public void deleteAnswerByQuestionID( int questionID){
        answerDAO.deleteByQuestionID(questionID);
    }

}