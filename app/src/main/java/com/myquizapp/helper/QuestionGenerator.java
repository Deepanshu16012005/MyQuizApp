package com.myquizapp.helper;

import com.myquizapp.data.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionGenerator {
    public static List<Questions> getQusetions(){
        List<Questions> qusetionList=new ArrayList<>();
        // Adding 10 Java-related questions to the list
        qusetionList.add(createJavaQuestion(1, "What is the main purpose of Java?", "Web Development", "Game Development", "Mobile App Development", "All of the above", "All of the above"));
        qusetionList.add(createJavaQuestion(2, "Which keyword is used for inheritance in Java?", "extends", "implements", "inherit", "interface", "extends"));
        qusetionList.add(createJavaQuestion(3, "What is a Java interface?", "A class", "A collection of methods", "A design pattern", "A blueprint for classes", "A blueprint for classes"));
        qusetionList.add(createJavaQuestion(4, "What is the default value of the local variables in Java?", "0", "null", "undefined", "Depends on the data type", "Depends on the data type"));
        qusetionList.add(createJavaQuestion(5, "What is the purpose of the 'super' keyword in Java?", "To call the superclass constructor", "To reference the current object", "To access static members", "To create an instance of a class", "To call the superclass constructor"));
        qusetionList.add(createJavaQuestion(6, "Which method is used for object serialization in Java?", "serialize()", "serializeObject()", "writeObject()", "saveObject()", "writeObject()"));
        qusetionList.add(createJavaQuestion(7, "What is the Java Virtual Machine (JVM)?", "A compiler", "A hardware component", "A runtime environment", "An operating system", "A runtime environment"));
        qusetionList.add(createJavaQuestion(8, "What is the purpose of the 'finally' block in a try-catch-finally statement?", "To handle exceptions", "To execute code whether an exception is thrown or not", "To specify the catch block", "To terminate the program", "To execute code whether an exception is thrown or not"));
        qusetionList.add(createJavaQuestion(9, "Which collection class is synchronized in Java?", "ArrayList", "HashSet", "Vector", "TreeSet", "Vector"));
        qusetionList.add(createJavaQuestion(10, "What is the difference between '== ' and 'equals()' in Java?", "They are identical", "'==' compares object references, 'equals()' compares object content", "'==' compares primitive types, 'equals()' compares objects", "'equals()' is used for assignment, '==' is used for comparison", "'==' compares object references, 'equals()' compares object content"));


        Collections.shuffle(qusetionList);
        return qusetionList;
    }
    private static Questions createJavaQuestion(int id, String question, String option1, String option2, String option3, String option4, String answer) {
        Questions javaQuestion = new Questions();
        javaQuestion.setId(id);
        javaQuestion.setQuestion(question);
        javaQuestion.setOption1(option1);
        javaQuestion.setOption2(option2);
        javaQuestion.setOption3(option3);
        javaQuestion.setOption4(option4);
        javaQuestion.setAns(answer);
        return javaQuestion;
    }
}
