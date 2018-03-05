
package se.johan.oh.dataaccess;

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
public interface DBCreateorInterface {
    
    public void createDB(String dbName);
    /**
     * @param subject
     */
    public void create(Subject subject);

    /**
     * @param chapter
     */
    public void create(Chapter chapter);

    /**
     * @param quiz the quiz to add
     */
    public void create(Quiz quiz);

    /**
     *
     * @param question
     */
    public void create(Question question);

    /**
     * @param answer
     */
    public void create(Answer answer);

    public void create(Person person);

    public void create(User user);
    public void create(UserPerson userPerson);
    
}
