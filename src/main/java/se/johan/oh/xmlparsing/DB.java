/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.johan.oh.xmlparsing;

import java.util.List;
import java.util.Map;
import se.johan.oh.containers.Chapter;
import se.johan.oh.containers.Question;
import se.johan.oh.containers.Quiz;
import se.johan.oh.containers.Subject;


/**
 * @author johan
 */
public class DB {
    
    String name; 
    
    Map<Integer,Subject> subjects;
    List<Chapter> chapters;
    Map<Integer,Quiz> quizzes;
    Map<Integer,Question> questions;
    
}
