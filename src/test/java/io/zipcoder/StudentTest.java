package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class StudentTest {
    Double[] grades;
    Student student;

    @Before
    public void initialize(){
        grades = new Double[5];
        student = new Student("JJ", "Bingus", grades);
    }

    @Test
    public void constructorTest(){
        //Given
        String expectedFirstName = "JJ";
        String expectedLastName = "Bingus";
        Double[] expectedGrades = grades;

        //When
        Student student = new Student(expectedFirstName, expectedLastName, grades);
        String actualFirstName = student.getFirstName();
        String actualLastName = student.getLastName();
        Double[] actualGrades = student.getGrades();

        //Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertArrayEquals(expectedGrades, actualGrades);

    }

    @Test
    public void setFirstNameTest(){
        //Given
        String expectedFirstName = "CJ";

        //When
        student.setFirstName(expectedFirstName);
        String actualFirstName = student.getFirstName();

        //Then
        Assert.assertEquals(expectedFirstName, actualFirstName);

    }

    @Test
    public void setLastNameTest(){
        //Given
        String expectedLastName = "Jenkins";

        //When
        student.setLastName(expectedLastName);
        String actualLastName = student.getLastName();

        //Then
        Assert.assertEquals(expectedLastName, actualLastName);

    }

    @Test
    public void getExamScoresTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        String expectedScores = Arrays.toString(examScores);
        Student student = new Student(firstName, lastName, examScores);

        // When
        String actualScores = student.getExamScores();

        // Then
        Assert.assertEquals(expectedScores, actualScores);
    }

    @Test
    public void addExamScoreTest(){
        //Given
        String firstName = "Bart";
        String lastName = "Simpson";
        Double[] examScores = {};
        Student student = new Student(firstName, lastName, examScores);
        String expectedScores = "[100.0]";

        //When
        student.addExamScore(100.0);
        String actualScores = student.getExamScores();

        //Then
        Assert.assertEquals(expectedScores, actualScores);

    }

    @Test
    public void setExamScoreTest(){
        //Given
        String firstName = "Lisa";
        String lastName = "Simpson";
        Double[] examScores = {100.00};
        Student student = new Student(firstName, lastName, examScores);
        String expectedScore = "[150.0]";

        //When
        student.setExamScore(1, 150.00); // We're counting scores from 1
        String actualScore = student.getExamScores();

        //Then
        Assert.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void getAverageExamScore(){
        //Given
        String firstName = "Martin";
        String lastName = "Prince";
        Double[] examScores = {100.0, 100.0, 200.0};
        Student student = new Student(firstName, lastName, examScores);
        Double expectedAvg = (100.0 + 100.0 + 200.0) / 3;

        //When
        Double actualAvg = student.getAverageExamScore();


        //Then
        Assert.assertEquals(expectedAvg, actualAvg);
    }

    @Test
    public void toStringTest(){
        //Given
        String firstName = "Nelson";
        String lastName = "Muntz";
        Double[] examScores = {25.0, 50.0};
        Student student = new Student(firstName, lastName, examScores);
        String expectedString = "Student Name: Nelson Muntz\n> Average Score: 37.5\n> Exam Scores:\n\tExam 1 -> 25.0\n\tExam 2 -> 50.0";

        //When
        String actualString = student.toString();

        //Then
        Assert.assertEquals(expectedString, actualString);



    }


}