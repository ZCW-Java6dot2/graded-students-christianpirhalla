package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScores));
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double[] getGrades() {
        return examScores.toArray(new Double[examScores.size()]);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getExamScores() {
        return Arrays.toString(examScores.toArray(new Double[examScores.size()]));
    }

    public void addExamScore(double score) {
        examScores.add(score);
    }

    public void setExamScore(int index, Double score) {
        examScores.set(index - 1, score); // Assuming the user is counting exams starting at 1
    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        for (Double d : examScores){
            sum += d;
        }
        return sum / examScores.size();
    }

    @Override
    public String toString(){
        StringBuilder studentString = new StringBuilder();
        studentString.append("Student Name: " + firstName + " " + lastName);
        studentString.append("\n> Average Score: " + getAverageExamScore());
        studentString.append("\n> Exam Scores:");
        for (int i = 0; i < examScores.size(); i++){
            studentString.append("\n\tExam " + (i+1) + " -> " + examScores.get(i));
        }
        return studentString.toString();
    }
}
