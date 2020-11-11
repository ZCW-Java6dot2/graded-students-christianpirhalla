package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ClassroomTest {

    @Test
    public void constructor1Test(){ //max number of students
        //Given
        int expectedNumStudents = 30;

        //When
        Classroom classroom = new Classroom(expectedNumStudents);
        int actualNumStudents = classroom.getStudents().length;

        //Then
        Assert.assertEquals(expectedNumStudents, actualNumStudents);
    }

    @Test
    public void constructor2Test(){ //students to be stored
        //Given
        Student[] expectedStudents = {new Student("Milhouse", "VanHouten", new Double[2]),
                new Student ("Ralph", "Wiggum", new Double[2])};

        //When
        Classroom classroom = new Classroom(expectedStudents);
        Student[] actualStudents = classroom.getStudents();

        //Then
        Assert.assertArrayEquals(expectedStudents, actualStudents);
    }

    @Test
    public void constructor3Test(){ //nullary
        //Given
        Student[] expectedStudents = new Student[30];

        //When
        Classroom classroom = new Classroom();
        Student[] actualStudents = classroom.getStudents();

        //Then
        Assert.assertArrayEquals(expectedStudents, actualStudents);
    }

    @Test
    public void getAverageExamScore(){
        //Given
        Double[] s1Scores = {50.00, 100.00};
        Double[] s2Scores = {75.00, 75.00};
        Student s1 = new Student("Abra", "Kadabra", s1Scores);
        Student s2 = new Student("Alla", "Khazam", s2Scores);
        Double expectedAvg = (s1.getAverageExamScore() + s2.getAverageExamScore()) / 2;
        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);

        //When
        Double actualAvg = classroom.getAverageExamScore();

        //Then
        Assert.assertEquals(expectedAvg, actualAvg);
    }

    @Test
    public void addStudentTest(){
        //Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Student student1 = new Student("Lonzo", "Ball", new Double[1]);
        Student student2 = new Student("Mo", "Bamba", new Double[1]);
        Student[] expectedStudents = {student1};

        //When
        classroom.addStudent(student1);
        Student [] actualStudents = classroom.getStudents();

        //Then
        Assert.assertArrayEquals(expectedStudents, actualStudents);

    }

    @Test
    public void addStudentTest2(){ //try to add one when there's no more room
        //Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Student student1 = new Student("Lonzo", "Ball", new Double[1]);
        Student student2 = new Student("Mo", "Bamba", new Double[1]);
        Student[] expectedStudents = {student1};

        //When
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        Student [] actualStudents = classroom.getStudents();

        //Then
        Assert.assertArrayEquals(expectedStudents, actualStudents);

    }

    @Test
    public void removeStudent(){
        //Given
        Student student1 = new Student("John", "Doe", new Double[1]);
        Student student2 = new Student("Jane", "Doe", new Double[1]);
        Student[] students = {student1, student2};
        Classroom classroom = new Classroom(students);
        Student[] expectedStudents = {student2, null};

        //When
        classroom.removeStudent("John", "Doe");
        Student[] actualStudents = classroom.getStudents();

        //Then
        Assert.assertArrayEquals(expectedStudents, actualStudents);
    }

    @Test
    public void getStudentsByScore(){
        //Given
        Double[] g1 = {100.00, 100.00, 90.00};
        Double[] g2 = {75.00, 80.00, 82.00};
        Student student1 = new Student("John", "Doe", g2);
        Student student2 = new Student("Jane", "Doe", g1);
        Student student3 = new Student("Jimmy", "Crumpf", g1);
        Student[] students = {student1, student2, student3};
        Classroom classroom = new Classroom(students);
        Student[] expectedList = {student3, student2, student1};
        //Jimmy and Jane have the same scores but Crumpf comes before Doe, and John has the lowest score

        //When
        Student[] actualList = classroom.getStudentsByScore();

        //Then
        Assert.assertArrayEquals(expectedList, actualList);
    }

    public void getStudentsByScore2(){ //try it with a null
        //Given
        Double[] g1 = {100.00, 100.00, 90.00};
        Double[] g2 = {75.00, 80.00, 82.00};
        Student student1 = new Student("John", "Doe", g2);
        Student student2 = new Student("Jane", "Doe", g1);
        Student student3 = new Student("Jimmy", "Crumpf", g1);
        Student[] students = {student1, null, student2, null, student3};
        Classroom classroom = new Classroom(students);
        Student[] expectedList = {student3, student2, student1, null, null};
        //Jimmy and Jane have the same scores but Crumpf comes before Doe, and John has the lowest score.
        //Null should be at the end

        //When
        Student[] actualList = classroom.getStudentsByScore();

        //Then
        Assert.assertArrayEquals(expectedList, actualList);
    }

    /** Should return a mapping of Student objects to a respective letter grade
     * determined by creating a grading curve such that:
     * A - upper 10th percentile
     * B - between 11th and 29th
     * C - between 30th and 50th
     * D - between 49 and 11
     * F - lower than 11
     */
    @Test
    public void getGradeBook(){
        //Given
        Double[] g1 = {89.00};
        Double[] g2 = {75.00};
        Double[] g3 = {56.00};
        Double[] g4 = {42.00};
        Double[] g5 = {20.00};

        Student s1 = new Student("Mister", "Crocker", g1);
        Student s2 = new Student("John", "Doe", g2);
        Student s3 = new Student("Jane", "Doe", g3);
        Student s4 = new Student("Jimmy", "D'oh", g4);
        Student s5 = new Student("Joao", "Souza", g5);
        Student[] students = {s5, s4, s3, s2, s1};
        Classroom classroom = new Classroom(students);

        HashMap<Student, String> gradeBook = new HashMap<Student, String>();
        gradeBook.put(s1, "A");
        gradeBook.put(s2, "B");
        gradeBook.put(s3, "C");
        gradeBook.put(s4, "D");
        gradeBook.put(s5, "F");
        //When
        HashMap<Student, String> actualGradebook = classroom.getGradebook();

        //Then
        Assert.assertEquals(gradeBook, actualGradebook);





    }


    public enum firstNames{
        Jesse,
        Antônio,
        Connor,
        Hendrix,
        Garrett,
        Gregory,
        James,
        Alan,
        Aaron,
        Alfonso,
        Alberto,
        Hassan,
        Hans,
        Geoff,
        DeShaun,
        Felipe,
        João,
        Pedro,
        Xavier,
        Javier,
        Jaques,
        Christian,
        Nicholas,
        Marcin,
        Calum,
        Artemis,
        Alice,
        Petunia,
        Dorothy,
        Alexia,
        Loretta,
        Késia,
        Eleodora,
        Eva,
        Yokhary,
        Ismary,
        Yasmín,
        Maralice,
        Cristina,
        Iris,
        Karla,
        Trinity
    }

    public enum lastNames{
        Souza,
        Monteiro,
        Valdez,
        Vázquez,
        vanHaarlem,
        Tanaka,
        Yamamoto,
        Hachimura,
        Lee,
        Zhang,
        Liu,
        Jensen,
        Ehrlich,
        Müller,
        Nowak,
        Smith,
        Richardson,
        Jansdóttir,
        Babatunde,
        Abioye,
        Laurent,
        Martín,
        Dubois,
        McCafferty,
        Donnegal,
        MacAgheny,
        OSullivan,
        Adamu,
        Ibrahim,
        DeJong,
        Vanderberg,
        Kohen,
        Katz,
        Herrera,
        Rossi,
        Russo,
        Esposito,
        Abdallah,
        Ali,
        Aziz
    }

    @Test
    public void seeBigDistribution(){
        Student[] students = new Student[50];
        Random random = new Random();

        for (int i = 0; i < students.length; i++){
            int pick = random.nextInt(firstNames.values().length);
            int pick2 = random.nextInt(lastNames.values().length);
            Double[] g = {(double) random.nextInt(25) + 65};
            students[i] = new Student(firstNames.values()[pick].toString(), lastNames.values()[pick2].toString(), g);
        }

        Classroom classroom = new Classroom(students);
        HashMap<Student, String> gradebook = classroom.getGradebook();

        for (Student s : gradebook.keySet()){
            System.out.println(s.getFirstName() + " " + s.getLastName() +
                    " | Final grade: " + s.getAverageExamScore() + " | " + gradebook.get(s));
        }

    }


}

