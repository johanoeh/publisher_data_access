
package se.johan.oh.containers;

import java.util.LinkedList;
import java.util.List;

/**
 * @author johan
 */
public class Quiz implements QuizInterface {

    protected int quizID;
    protected int subjectID;
    protected String quizName;
    
    List<Question> questions;
    
    public Quiz(int quizID, int subjectID, String quizName) {
        initQuiz(quizID, subjectID, quizName);
        this.questions = new LinkedList<>();
    }
    
    @Override
    public void initQuiz(int quizID, int subjectID, String quizName) {
        this.quizID = quizID;
        this.subjectID = subjectID;
        this.quizName = quizName; 
    }

    @Override
    public int getSubjectID() {
        return subjectID;
    }

    @Override
    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    @Override
    public int getQuizID() {
        return quizID;
    }

    @Override
    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    @Override
    public String getQuizName() {
        return quizName;
    }

    @Override
    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
    
     public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    public void addQuestion(Question question){
        questions.add(question);
    }
    
    @Override
    public String toString(){
        return COLUMNS[0]+" : "+quizID+", "+COLUMNS[1]+" : "+subjectID+", "+COLUMNS[2]+" : "+quizName;
    };  

   
}

