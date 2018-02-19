/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.xmlparsing;

import org.xml.sax.Attributes;
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
public class XMLParseUtils {

    /*Methods used to create objects from XML attributes******************************/
    //Chapter(Integer chapterID,int subjectID ,String chapterName, Integer priority, String contentHTML)
    public static Chapter createChapter(Attributes atts) {
        Chapter chapter = new Chapter(
                Integer.parseInt(
                        atts.getValue("chapterID")),
                0, atts.getValue("chapterName"),
                Integer.parseInt(atts.getValue("priority")),
                ""
        );
        return chapter;
    }

    /**
     *
     * @param atts
     * @return
     */
    public static Quiz createQuiz(Attributes atts) {
        Quiz quiz = new Quiz(
                Integer.parseInt(atts.getValue("quizID")),
                0,
                atts.getValue("quizName")
        );
        return quiz;
    }

    /**
     * @param atts
     * @return
     */
    public static User createUser(Attributes atts) {
        User user
                = new User(
                        Integer.parseInt(atts.getValue("userID")),
                        atts.getValue("userName"),
                        atts.getValue("password")
                );
        return user;
    }

    /**
     *
     * @param atts
     * @return
     */
    public static Person createPerson(Attributes atts) {
        Person person
                = new Person(Integer.parseInt(
                        atts.getValue("userID")),
                        atts.getValue("firstName"),
                        atts.getValue("middleName"),
                        atts.getValue("lastName"),
                        atts.getValue("email"),
                        atts.getValue("country"),
                        atts.getValue("streetAddress"),
                        atts.getValue("city"),
                        atts.getValue("postalCode"));
        return person;
    }

    /**
     *
     * @param atts
     * @return
     */
    public static Subject createSubject(Attributes atts) {
        Subject subject
                = new Subject(
                        atts.getValue("subjectName"),
                        "",
                        Integer.parseInt(atts.getValue("subjectID"))
                );
        return subject;
    }

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
    
    
    public static Question createQuestion(Attributes atts){
        Question question = new Question(0, 0, atts.getValue("text"));
        return question;
    }
    
    public static Answer createAnswer(Attributes atts){
        Answer answer = new Answer(
                Integer.parseInt(atts.getValue("answerID")),
                Integer.parseInt(atts.getValue("questionID")), 
                atts.getValue("answerText"),
                Boolean.parseBoolean(atts.getValue("truthValue"))
        );
        return answer;
    }

    public static void parse(Attributes atts, String qName) {

    }

}
