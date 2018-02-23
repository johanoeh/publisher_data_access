/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.dataaccess;

import java.util.List;
import se.johan.oh.containers.Answer;
import se.johan.oh.containers.Chapter;
import se.johan.oh.containers.Person;
import se.johan.oh.containers.Question;
import se.johan.oh.containers.Quiz;
import se.johan.oh.containers.Subject;
import se.johan.oh.containers.User;

/**
 *
 * @author johan
 */
public interface DataAccessInterface {

    /**
     * Adds a new subject to db
     *
     * @param subject to add
     */
    int create(Subject subject);

    /*Access methods for chapters --------------------------------------------*/
    /**
     * @param chapter to add
     * @return
     */
    int create(Chapter chapter);
    
    /**
     * @param chapterID
     */
    void deleteChapter(int chapterID);

    /* Access methods for users-----------------------------------------------*/
    /**
     *
     * @param user
     */
    int create(User user);

    /*Access methods for Person ---------------------------------------------*/
    int create(Person person);

    /*Access methods for quizzes----------------------------------------------*/
    int create(Quiz quiz);

    /* Access methods for answers --------------------------------------------*/
    int create(Answer answer);

    /* Access methods for Questions ------------------------------------------*/
    int createQuestion(Question question);

    void deleteAnswer(int answerID);

    void deleteAnswerByQuestionID(int questionID);

    void deleteByQuestionID(int questionID);

    

    void deletePerson(Integer id);

    void deleteQuiz(int quizID);

    void deleteQuizBySubjectID(int SubjectID);

    /**
     * Deletes a subject and all it's related chapters
     *
     * @param subjectID id of subject to delete
     */
    void deleteSubject(int subjectID);

    /**
     *
     * @param userID
     */
    void deleteUser(int userID);

    /**
     *
     * @param subjectID
     * @return
     */
    List<Chapter> readAllChapters(int subjectID);

    List<Person> readAllPersons();

    /* Access methods for subjects -------------------------------------------*/
    /**
     * Returns a list of all subjects from db
     *
     * @return
     */
    List<Subject> readAllSubjects();

    /**
     *
     * @return
     */
    List<User> readAllusers();

    List<Answer> readAnswerByQuestionID(int questionID);

    Chapter readChapter(int chapterID);

    Person readPerson(int userID);

    List<Question> readQuestionByQuizID(int quizID);

    List<Quiz> readQuiz(int subjectID);

    /**
     *
     * @param id
     * @return
     */
    Subject readSubject(int id);

    /**
     *
     * @param userID
     * @return
     */
    User readUser(int userID);

    void update(Quiz quiz);

    void update(Question question);

    void update(Answer answer);

    /**
     *
     * @param chapterID
     * @param chapter
     */
    void updateChapter(int chapterID, Chapter chapter);

    void updatePerson(Person person);

    /**
     *
     * @param user
     */
    void updateUser(User user);

    public void createDB(String test);
    
}
