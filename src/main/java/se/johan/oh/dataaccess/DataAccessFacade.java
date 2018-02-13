
package se.johan.oh.dataaccess;



import se.johan.oh.containers.Answer;
import se.johan.oh.containers.Subject;
import se.johan.oh.containers.Chapter;
import se.johan.oh.containers.Person;
import se.johan.oh.containers.Question;
import se.johan.oh.containers.Quiz;
import se.johan.oh.containers.User;
import java.util.List;


/**
 * @author johan
 */
public class DataAccessFacade {

    SubjectDataAccess subjectDAO;
    ChapterDataAccess chapterDAO;
    UsersDataAccess userDAO;
    PersonDataAccess personDAO;
    QuizDataAccess quizDAO;
    QuestionDataAccess questionDAO;
    AnswerDataAccess answerDAO;

    public DataAccessFacade(){
        subjectDAO = new SubjectDataAccess();
        chapterDAO = new ChapterDataAccess();
        userDAO = new UsersDataAccess();
        personDAO = new PersonDataAccess();
        quizDAO = new QuizDataAccess();
        questionDAO = new QuestionDataAccess();
        answerDAO = new AnswerDataAccess();
    }
 
    
    /* Access methods for subjects -------------------------------------------*/

    /**
     * Returns a list of all subjects from db
     *
     * @return
     */
    public List<Subject> readAllSubjects() {
       System.out.print("Hello from read subject");
        return subjectDAO.readAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Subject readSubject(int id) {
        return subjectDAO.read(id);
    }

    /**
     * Adds a new subject to db
     *
     * @param subject to add
     */
    public int create(Subject subject) {
        return subjectDAO.create(subject);
    }

    /**
     * Deletes a subject and all it's related chapters
     *
     * @param subjectID id of subject to delete
     */
    public void deleteSubject(int subjectID) {
        subjectDAO.delete(subjectID);
    }

    
    /*Access methods for chapters --------------------------------------------*/
    
    /**
     * @param chapter to add
     * @return 
     */
    public int create(Chapter chapter) {
        return chapterDAO.create(chapter);
    }

    public Chapter readChapter(int chapterID) {
        return chapterDAO.read(chapterID);
    }
  
    /**
     *
     * @param subjectID
     * @return
     */
    public List<Chapter> readAllChapters(int subjectID) {
        return chapterDAO.readAll(subjectID);
    }

    /**
     *
     * @param chapterID
     */
    public void deleteChapter(int chapterID) {
        chapterDAO.delete(chapterID);
    }

    /**
     *
     * @param chapterID
     * @param chapter
     */
    public void updateChapter(int chapterID, Chapter chapter) {
        chapterDAO.update(chapterID, chapter);
    }
    
    
    /* Access methods for users-----------------------------------------------*/

    /**
     *
     * @param user
     */
    public int create(User user){
        return userDAO.create(user);
    }
    
    /**
     *
     * @param userID
     */
    public void deleteUser(int userID){
     userDAO.delete(userID);
    }
    
    /**
     *
     * @param user
     */
    public void updateUser(User user){
        userDAO.update(user);
    }
    
    /**
     *
     * @param userID
     * @return
     */
    public User readUser(int userID){
        return userDAO.read(userID);
    }
    
    /**
     *
     * @return
     */
    public List<User> readAllusers(){
        return userDAO.readAll();
    }
    
    /*Access methods for Person ---------------------------------------------*/
    public int create(Person person){
       return personDAO.create(person);
    }
    
    public Person readPerson(int userID){
        return personDAO.read(userID);
    }
    
    public List<Person> readAllPersons(){
        return personDAO.readAll();
    }
    
    
    public void updatePerson(Person person){
        personDAO.update(person);
    }

    public void deletePerson(Integer id) {
       personDAO.delete(id);
    }
    
    /*Access methods for quizzes----------------------------------------------*/
    public int create(Quiz quiz){
       return quizDAO.create(quiz);
    }
    
    public List<Quiz> readQuiz(int subjectID){
        return quizDAO.readBySubjectID(subjectID);
    }
    
    public void update(Quiz quiz){
        quizDAO.update(quiz);
    }

    
    public void deleteQuiz(int quizID){
      quizDAO.delete(quizID);
    }
    
    public void deleteQuizBySubjectID(int SubjectID){
        quizDAO.deleteBySubjectID(SubjectID);
    }
    
    /* Access methods for Questions ------------------------------------------*/
    
    public int createQuestion(Question question){
        return questionDAO.create(question);
    }
    
    public List<Question> readQuestionByQuizID(int quizID){
        return questionDAO.readByQuizID(quizID);
    }
    
    public void update(Question question){
        questionDAO.update(question);
    }

    public void deleteByQuestionID(int questionID) {
        questionDAO.deleteByQuestionID(questionID);
    }
    
    /* Access methods for answers --------------------------------------------*/  
    public int create(Answer answer){
        return answerDAO.create(answer);
    }
    
    public List<Answer> readAnswerByQuestionID(int questionID){
        return answerDAO.readByQuestionID(questionID);
    }
    
    public void update(Answer answer){
        answerDAO.update(answer);
    }
    
    public void deleteAnswer( int answerID){
        answerDAO.deletetByID(answerID);
    }
    
     public void deleteAnswerByQuestionID( int questionID){
        answerDAO.deleteByQuestionID(questionID);
    }

}
