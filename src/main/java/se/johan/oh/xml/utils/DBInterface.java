
package se.johan.oh.xml.utils;

import se.johan.oh.containers.Answer;
import se.johan.oh.containers.Chapter;
import se.johan.oh.containers.Person;
import se.johan.oh.containers.Question;
import se.johan.oh.containers.Quiz;
import se.johan.oh.containers.Subject;
import se.johan.oh.containers.User;
import se.johan.oh.containers.UserPerson;

/**
 * Minimal interface
 * Should implement methods to create database and methods to add each of the object
 * as an entry in the database.
 * database
 * @author johan
 */
public interface DBInterface {
    
    void createDB(String dbName);
    
    public String getDBName();

    /**
     * @param subject
     */
    void create(Subject subject);

    /**
     * @param chapter
     */
    void create(Chapter chapter);

    /**
     * @param quiz the quiz to add
     */
    void create(Quiz quiz);

    /**
     *
     * @param question
     */
    void create(Question question);

    /**
     * @param answer
     */
    void create(Answer answer);

    public void create(Person person);

    public void create(User user);
    public void create(UserPerson userPerson);
    
}
