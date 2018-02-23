
package se.johan.oh.xml.utils;

import se.johan.oh.containers.Answer;
import se.johan.oh.containers.Chapter;
import se.johan.oh.containers.Person;
import se.johan.oh.containers.Question;
import se.johan.oh.containers.Quiz;
import se.johan.oh.containers.Subject;
import se.johan.oh.containers.User;

/**
 * Minimal dataccess interface used to create objects and insert them into the 
 * database
 * @author johan
 */
public interface DBInterface {

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

    void createDB(String dbName);
    
    public String getDBName();

    public void create(Person person);

    public void create(User user);
    
}
