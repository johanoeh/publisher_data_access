
package se.johan.oh.xml;

import se.johan.oh.xml.utils.XMLToRelationalInterface;
import se.johan.oh.xml.utils.SaxAttributeHandler;
import java.util.LinkedList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import se.johan.oh.containers.Answer;
import se.johan.oh.containers.Chapter;
import se.johan.oh.containers.Person;
import se.johan.oh.containers.Question;
import se.johan.oh.containers.Quiz;
import se.johan.oh.containers.Subject;
import se.johan.oh.containers.User;
import se.johan.oh.xml.utils.SimpleXMLElement;

/**
 * @author johan
 */
public class SubjectXMLDataHandler extends DefaultHandler {

    public static final String NAME_SPACE = "ns1:";
    public static final String DB = NAME_SPACE + "db";
    public static final String PERSON = NAME_SPACE + "person";
    public static final String USER = NAME_SPACE + "user";
    public static final String SUBJECT = NAME_SPACE + "subject";
    public static final String DESCRIPTION_HTML = NAME_SPACE + "descriptionhtml";
    public static final String CHAPTER = NAME_SPACE + "chapter";
    public static final String CONTENT_HTML = NAME_SPACE + "contenthtml";
    public static final String QUIZ = NAME_SPACE + "quiz";
    public static final String QUESTION = NAME_SPACE + "question";
    public static final String ANSWER = NAME_SPACE + "answer";

    private String DBName = "";
    private boolean bDescriptionHTML;
    private boolean bContentHTML;


    private SimpleXMLElement currentChapterHTML = null;
    private SimpleXMLElement currenSubjectXHTML;
    
    private Subject currentSubject;
    private Chapter currentChapter;
    private Quiz currentQuiz;
    private Question currentQuestion;
    
    private final List<Subject> subjects;
    private XMLToRelationalInterface xmlToRelationalHandler;
    
    public SubjectXMLDataHandler(XMLToRelationalInterface xmlToRelationalHandler) {
        subjects = new LinkedList<>();
        this.xmlToRelationalHandler = xmlToRelationalHandler;
    }

    @Override
    public void startDocument() throws SAXException {
    }

    
    
    /**
     * Handles the event of a XML startelement <element name>
     * Attributes are handled here as well
     * 
     * @param namespaceURI
     * @param localName
     * @param qName
     * @param atts
     * @throws org.xml.sax.SAXException
     */
    @Override
    public void startElement(
            String namespaceURI,
            String localName,
            String qName,
            Attributes atts
    ) throws SAXException {
        qName = qName.toLowerCase();
        switch (qName) {
            case DB:
                DBName = SaxAttributeHandler.getDBName(atts);
                xmlToRelationalHandler.createDB(DBName);
                break;
            case PERSON:
                Person person = SaxAttributeHandler.createPerson(atts);
                xmlToRelationalHandler.create(person);
                break;
            case USER:
                User user = SaxAttributeHandler.createUser(atts);
                xmlToRelationalHandler.create(user);
                break;
            case SUBJECT:
                currentSubject = SaxAttributeHandler.createSubject(atts);
                xmlToRelationalHandler.create(currentSubject);
                break;
            case DESCRIPTION_HTML:
                bDescriptionHTML = true;
                currenSubjectXHTML = new SimpleXMLElement(DESCRIPTION_HTML);
                break;
            case CHAPTER:
                currentChapter = SaxAttributeHandler.createChapter(atts);
                currentSubject.addChapter(currentChapter);
                break;
            case CONTENT_HTML:
                bContentHTML = true;
                currentChapterHTML = new SimpleXMLElement(CONTENT_HTML);    
                break;
            case QUIZ:
                currentQuiz = SaxAttributeHandler.createQuiz(atts);
                xmlToRelationalHandler.create(currentQuiz);
                break;
            case QUESTION:
                currentQuestion = SaxAttributeHandler.createQuestion(atts);
                xmlToRelationalHandler.create(currentQuestion);
                break;
            case ANSWER:
                Answer answer = SaxAttributeHandler.createAnswer(atts);
                //currentQuestion.addAnswer(SaxAttributeHandler.createAnswer(atts));
                xmlToRelationalHandler.create(answer);
                break;
        }
        
        if (bContentHTML && !qName.equalsIgnoreCase(CONTENT_HTML)) {
            String xmlPart = qName + SaxAttributeHandler.buildAttributeString(atts);
            currentChapterHTML.appendStartTag(xmlPart);
        } 
        if (bDescriptionHTML && !qName.equalsIgnoreCase(DESCRIPTION_HTML)){
            String xmlPart = qName + SaxAttributeHandler.buildAttributeString(atts);
            currenSubjectXHTML.appendStartTag(xmlPart);  
        }
    }


    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bDescriptionHTML) {
            currenSubjectXHTML.append(new String(ch, start, length));
        }
        if (bContentHTML) {
            currentChapterHTML.append(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
        switch (qName.toLowerCase()) {
            case SUBJECT:
                currentSubject.setDescriptionHTML(currenSubjectXHTML.toString());
                xmlToRelationalHandler.create(currentSubject);
                subjects.add(currentSubject);
            case DESCRIPTION_HTML:
                bDescriptionHTML = false;
                break;
            case CHAPTER:
                currentChapter.setContentHTML(currentChapterHTML.toString());
                break;
            case CONTENT_HTML:
                bContentHTML = false;
                break;
            case QUIZ:
                currentSubject.add(currentQuiz);
                break;
            case QUESTION:
                currentQuiz.addQuestion(currentQuestion);
                break;
            case ANSWER:
                break;
        }
        
        if (bContentHTML){
            currentChapterHTML.appendEndTag(qName);
        }
        
        if(bDescriptionHTML){
            currenSubjectXHTML.appendEndTag(qName);
        }
    }

    @Override
    public void endDocument() throws SAXException {   
       /* System.out.println("!!!! ---- Content received from XML document ---- !!!!");
        for (Subject subject: subjects) {
            System.out.println(subject.toString());   
            for(Chapter chapter : subject.getChapters()){
                System.out.println(chapter.toString());
            }  
            for(Quiz quiz : subject.getQuizzes()){
                System.out.println(quiz.toString());
                for(Question question: quiz.getQuestions()){
                    System.out.println(question.toString());
                    for(Answer answer : question.getAnswers()){
                        System.out.println(answer.toString());
                    }
                }
            }
        }
     */  
    }
}
