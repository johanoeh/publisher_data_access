/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.SQL.test;

import se.johan.oh.containers.Answer;
import se.johan.oh.containers.Chapter;
import se.johan.oh.containers.Person;
import se.johan.oh.containers.Question;
import se.johan.oh.containers.Quiz;
import se.johan.oh.containers.Subject;
import se.johan.oh.containers.User;
import se.johan.oh.dataaccess.DataAccessFacade;

/**
 *
 * @author johan
 */
public class Test {
    
    public static final Subject TEST_SUBJECT = new Subject("Test subject","<h> hello</h> ", 0);
    private DataAccessFacade dao;
    private int currentSubjectID;
    
    public void Test(){
        currentSubjectID = -1;
    }
    
   public void runTest(){
       
       dao = new DataAccessFacade();
       currentSubjectID = dao.create(new Subject("Test subject","<h> hello</h> ", 0));
       int chapterID = -1;
       int quizID = -1;
       int uID = -1;
       int pID = -1;
       int questionID = -1;
       int answerID = -1;
       User user  = new User(1, "johan.oh@gmail.com", "simplePassword");
       uID= dao.create(user);
       System.out.println(uID);
       
       if(uID >= 0){
           System.out.println("Succefully create user with ID: " + uID);
           Person person = new Person(uID, "Johan", "Mikael", "Öh", "johan.oh@mail.com", "Sweden","Sweden", "Sundsvall","853 53");
           pID = dao.create(person);
       }
       
       if(pID >=0){
           System.out.println("Successfully created Person wiht id " +pID);
       }
       
       if(currentSubjectID >= 0){
            System.out.println("successfully created subject with id: "+currentSubjectID);
            chapterID = dao.create(new Chapter(0, currentSubjectID , "chapter one", 1, "<h1> hello from chapter one"));
            Quiz quiz = new Quiz(quizID, currentSubjectID,"Quiz chapter one");
            quizID = dao.create(quiz);           
       }
       
       if(chapterID >=0 ){
           System.out.println("successfully created chapter with id: "+ chapterID);
       }
       
       if (quizID >= 0) {
           System.out.println("successfully created quiz with id: " + quizID);
           Question question = new Question(0, quizID, "What is true?");
           questionID = dao.createQuestion(question);
       }
       
       if(questionID >= 0){
           System.out.println("successfully created question with ID: " + questionID);
           Answer answer = new Answer(1, questionID,"Something is true", Boolean.TRUE);
           answerID = dao.create(answer);
       }
       
       if(answerID >=0){
           System.out.println("Successfully created answer with ID: "+answerID);
       }
    }
}
