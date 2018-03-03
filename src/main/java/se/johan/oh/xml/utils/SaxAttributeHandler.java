
package se.johan.oh.xml.utils;

import org.xml.sax.Attributes;
import se.johan.oh.containers.Answer;
import se.johan.oh.containers.Chapter;
import se.johan.oh.containers.Person;
import se.johan.oh.containers.Question;
import se.johan.oh.containers.Quiz;
import se.johan.oh.containers.Subject;
import se.johan.oh.containers.User;

/**
 * Class used to create java objects from XML elements attributes
 * @author johan
 */
public class SaxAttributeHandler {
    
    public static final String CONNECTION_STRING_ATTRIBUTE = "dbConnectionString";
    
    public static final String CHAPTER_ID = "chapterID";
    public static final String CHAPTER_NAME ="chapterName";
    public static final String PRIORITY ="priority";
    
    public static final String QUIZ_ID ="quizID";
    public static final String QUIZ_NAME = "quizName";
    
    public static final String USER_ID = "userID";
    public static final String USER_NAME = "userName";
    public static final String PASSWORD = "password";
    

    public static final String FIRST_NAME = "firstName";
    public static final String MIDDLE_NAME = "middleName";
    public static final String LAST_NAME = "lastName";
    public static final String E_MAIL = "email";
    public static final String COUNTRY = "country";
    public static final String STREET_ADDRESS = "streetAddress";
    public static final String CITY = "city";
    public static final String POSTAL_CODE  = "postalCode";
    
    
    public static final  String SUBJECT_NAME = "subjectName";
    public static final String SUBJECT_ID = "subjectID";
    
    public static final String TEXT ="text";
    public static final String ANSWER_ID ="answerID";
    public static final String QUESTION_ID ="questionID";
    
    public static final String ANSWER_TEXT ="answerText";
    public static String TRUTH_VALUE = "truthValue";
    
    

     public static String createConnectionString(Attributes atts){
         return atts.getValue(CONNECTION_STRING_ATTRIBUTE);
     }
    /**
     * Creates a Chapter object from chapter XML elements attributes
     * @param atts
     * @return
     */
    public static Chapter createChapter(Attributes atts) {
        Chapter chapter = new Chapter(
                Integer.parseInt(
                        atts.getValue(CHAPTER_ID)),
                0, atts.getValue(CHAPTER_NAME),
                Integer.parseInt(atts.getValue(PRIORITY)),
                ""
        );
        return chapter;
    }

    /**
     *  Creates a Quiz object from quiz XML elements attributes
     * @param atts
     * @return
     */
    public static Quiz createQuiz(Attributes atts) {
        Quiz quiz = new Quiz(
                Integer.parseInt(atts.getValue(QUIZ_ID)),
                0,
                atts.getValue(QUIZ_NAME)
        );
        return quiz;
    }

    /**
     * creates a User object from xml element users attributes
     * @param atts
     * @return
     */
    public static User createUser(Attributes atts) {
        User user
                = new User(
                        Integer.parseInt(atts.getValue(USER_ID)),
                        atts.getValue(USER_NAME),
                        atts.getValue(PASSWORD)
                );
        return user;
    }

    /**
     * creates a Person from xml element user's attributes
     * @param atts
     * @return
     */
    public static Person createPerson(Attributes atts) {
        Person person
                = new Person(
                        Integer.parseInt(atts.getValue(USER_ID)),
                        atts.getValue(FIRST_NAME),
                        atts.getValue(MIDDLE_NAME),
                        atts.getValue(LAST_NAME),
                        atts.getValue(E_MAIL),
                        atts.getValue(COUNTRY),
                        atts.getValue(STREET_ADDRESS),
                        atts.getValue(CITY),
                        atts.getValue(POSTAL_CODE));
        return person;
    }

    
    /**
     * creates a Subject object from XML element subject(s)  attributes
     * @param atts
     * @return
     */
    public static Subject createSubject(Attributes atts) {
        Subject subject
                = new Subject(
                        atts.getValue(SUBJECT_NAME),
                        "",
                        Integer.parseInt(atts.getValue(SUBJECT_ID))
                );
        return subject;
    }
    
        
    /**
     * @param atts
     * @return
     */
    public static Question createQuestion(Attributes atts){
        Question question = new Question(0, 0, atts.getValue(TEXT));
        return question;
    }
    
    public static Answer createAnswer(Attributes atts){
        Answer answer = new Answer(
                Integer.parseInt(atts.getValue(ANSWER_ID)),
                Integer.parseInt(atts.getValue(QUESTION_ID)), 
                atts.getValue(ANSWER_TEXT),
                Boolean.parseBoolean(atts.getValue(TRUTH_VALUE))
        );
        return answer;
    }
    

    /**
     * creates a string containing all attributes and their values as they are
     * formatted in an XML document
     * @param atts
     * @return
     */
    public static String buildAttributeString(Attributes atts) {
        String attributeString = " ";
        for (int i = 0; i < atts.getLength(); i++) {
            if (!(i + 1 == atts.getLength())) {
                attributeString += atts.getQName(i) + "=" + "\"" + atts.getValue(i) + "\" ";
            } else {
                attributeString += atts.getQName(i) + "=" + "\"" + atts.getValue(i) + "\"";
            }
        }
        if (attributeString.equals(" ")) {
            return "";
        }
        return attributeString;
    }


}
