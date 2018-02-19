
package se.johan.oh.xmlparsing;

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
import se.johan.oh.xmlparsing.XMLcontainers.SimpleXMLElement;

/**
 * @author johan
 */
public class XMLDataHandler extends DefaultHandler {

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
    private boolean bChapter;
    private boolean bContentHTML;
    private boolean bQuiz;
    private boolean bQuestion;
    private boolean bAnswer;

    private SimpleXMLElement contentHTML = null;
    List<SimpleXMLElement> elements;
    
    private Subject currentSubject;
    private Chapter currentChapter;
    private Quiz currentQuiz;
    private Question currentQuestion;
    private SimpleXMLElement currenSubjectXHTML;
    private List<Subject> subjects;
   

    public XMLDataHandler() {
        elements = new LinkedList<>();
        subjects = new LinkedList<>();
    }

    @Override
    public void startDocument() throws SAXException {
    }

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
                DBName = atts.getValue(3);
                break;
            case PERSON:
                Person person = XMLParseUtils.createPerson(atts);
                System.out.println(person.toString());
                break;
            case USER:
                User user = XMLParseUtils.createUser(atts);
                System.out.println(user.toString());
                break;
            case SUBJECT:
                currentSubject = XMLParseUtils.createSubject(atts); 
                break;
            case DESCRIPTION_HTML:
                bDescriptionHTML = true;
                currenSubjectXHTML = new SimpleXMLElement(DESCRIPTION_HTML);
                break;
            case CHAPTER:
                bChapter = true;
                currentChapter = XMLParseUtils.createChapter(atts);
                currentSubject.addChapter(currentChapter);
                break;
            case CONTENT_HTML:
                bContentHTML = true;
                contentHTML = new SimpleXMLElement(CONTENT_HTML);    
                break;
            case QUIZ:
                bQuiz = true;
                currentQuiz = XMLParseUtils.createQuiz(atts);
                break;
            case QUESTION:
                bQuestion = true;
                currentQuestion = XMLParseUtils.createQuestion(atts); 
                break;
            case ANSWER:
                bAnswer = true;
                
                Answer answer = XMLParseUtils.createAnswer(atts);
                currentQuestion.addAnswer(XMLParseUtils.createAnswer(atts));
                break;
        }
        
        if (bContentHTML && !qName.equalsIgnoreCase(CONTENT_HTML)) {
            String xmlPart = qName + XMLParseUtils.buildAttributeString(atts);
            contentHTML.appendStartTag(xmlPart);
        } 
        if (bDescriptionHTML && !qName.equalsIgnoreCase(DESCRIPTION_HTML)){
            String xmlPart = qName + XMLParseUtils.buildAttributeString(atts);
            currenSubjectXHTML.appendStartTag(xmlPart);  
        }
    }


    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bDescriptionHTML) {
            currenSubjectXHTML.append(new String(ch, start, length));
        }
        if (bContentHTML) {
            contentHTML.append(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
        switch (qName.toLowerCase()) {
            case SUBJECT:
                currentSubject.setDescriptionHTML(currenSubjectXHTML.toString());
                subjects.add(currentSubject);
            case DESCRIPTION_HTML:
                bDescriptionHTML = false;
                break;
            case CHAPTER:
                bChapter = false;
                currentChapter.setContentHTML(contentHTML.toString());
                break;
            case CONTENT_HTML:
                bContentHTML = false;
                break;
            case QUIZ:
                bQuiz = false;
                currentSubject.add(currentQuiz);
                break;
            case QUESTION:
                bQuestion = false;
                currentQuiz.addQuestion(currentQuestion);
                break;
            case ANSWER:
                bAnswer = false;
                break;
        }

        if (bContentHTML) {
            contentHTML.appendEndTag(qName);
        }
        
        if(bDescriptionHTML){
            currenSubjectXHTML.appendEndTag(qName);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        //System.out.println(XMLStringBuilder.build(elements));
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
       
    }
}
