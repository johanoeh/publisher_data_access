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

   

    /*Access methods for chapters --------------------------------------------*/
    /**
     * @param chapter to add
     * @return
     */
    public int create(Chapter chapter);
    
    /**
     * Reads a chapter based on chapter ID
     * @param chapterID
     * @return the chapter with id
     */
    public Chapter readChapter(int chapterID);
    
    /**
     *
     * @param chapterID
     * @param chapter
     */
    public void updateChapter(int chapterID, Chapter chapter);
    
     /**
     *
     * @param subjectID
     * @return
     */
    public List<Chapter> readAllChapters(int subjectID);
    
    /**
     * @param chapterID
     */
    public void deleteChapter(int chapterID);
    
  

    /* Access methods for users ----------------------------------------------*/
    
    /**
     * @param user
     */
    public int create(User user);
    
    /**
     * @param userID
     * @return
     */
    public User readUser(int userID);
    
    /**
     * @return
     */
    public List<User> readAllusers();
    
    /**
     * @param userID
     */
    public void deleteUser(int userID);

    /*Access methods for Person ---------------------------------------------*/
    
    public int create(Person person);
    
    /**
     * @param userID
     * @return
     */
    public Person readPerson(int userID);
    
    /**
     * @return
     */
    public List<Person> readAllPersons();
    
    /**
     *
     * @param id
     */
    public void deletePerson(Integer id);
    
    
    

    /*Access methods for quiz objects ----------------------------------------*/
    public int create(Quiz quiz);
    
    public List<Quiz> readQuiz(int subjectID);

    public void update(Quiz quiz);

    public void deleteQuiz(int quizID);

    public void deleteQuizBySubjectID(int SubjectID);
    
   

   

    /* Access methods for Questions ------------------------------------------*/
    public int createQuestion(Question question);

    public void deleteByQuestionID(int questionID);
    
    /* Access methods for answers --------------------------------------------*/
    public int create(Answer answer);
    
    public List<Answer> readAnswerByQuestionID(int questionID);

    public void update(Answer answer);
    
    public void deleteAnswer(int answerID);
    
    public void deleteAnswerByQuestionID(int questionID);


  

    /* Access methods for subjects -------------------------------------------*/
    
    /**
     * Returns a list of all subjects
     * @return
     */
    public List<Subject> readAllSubjects();

    /**
     * @param id
     * @return
     */
    public Subject readSubject(int id);
    
     /**
     * Adds a new subject to db
     * @param subject to add
     * @return id of created subject
     */
     public int create(Subject subject);
    
    /**
     * Deletes a subject and all it's related chapters
     *
     * @param subjectID id of subject to delete
     */
    public void deleteSubject(int subjectID);

    /**
     *
     * @param quizID
     * @return
     */
    public List<Question> readQuestionByQuizID(int quizID);

    /**
     *
     * @param question
     */
    public void update(Question question);

    /**
     *
     * @param person
     */
    public void updatePerson(Person person);

    /**
     *
     * @param user
     */
    public void updateUser(User user);   
}
