package io.zipcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/*
/////////////   T O   D O   ////////////
-cleaner percentile calculation.  Helper method?
-make sure I'm doing the sorting in the best way possible
    - Do I need a separate sort by ascending comparator? Can I just reverse the one I had?

 */


public class Classroom {
    private Student[] students;

    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        for (int i = 0; i < students.length; i++){
            sum += students[i].getAverageExamScore();
        }
        return sum / students.length;
    }

    public void addStudent(Student newStudent) {
        //iterate through the array and put newStudent at the first occurrence of null;
        for (int i = 0; i < students.length; i++){
            if (students[i] == null){
                students[i] = newStudent;
                break;
            }
        }
    }


    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length; i++){
            if (students[i].getFirstName().equals(firstName) &&
                    students[i].getLastName().equals(lastName)){
                students[i] = null;
                break;
            }
        }
    Arrays.sort(students, new SortNulls());
    }

    public Student[] getStudentsByScore() {
        Arrays.sort(students, new SortByScoreAndLastName());
        return students;
    }


    public HashMap<Student, String> getGradebook(){
        //sort students
        Arrays.sort(students, new SortByScoreAndLastNameAscending());

        //determine percentiles
        //formula - the nth percentile is at the index of n * (sample size), rounded to the next closest integer,
        // minus 1 to account for arrays' 0 indexing
        double ninetieth = students[(int)Math.round(.9 * students.length) - 1].getAverageExamScore();
        double seventyfirst = students[(int)Math.round(.71 * students.length) - 1].getAverageExamScore();
        double fiftieth = students[(int)Math.round(.50 * students.length) - 1].getAverageExamScore();
        double eleventh = students[(int)Math.round(.11 * students.length) - 1].getAverageExamScore();

        //map students accordingly
        HashMap<Student, String> gradeBook = new HashMap<>();
        for (Student s : students){

            if (s == null) {continue;} //skip nulls

            double currGrade = s.getAverageExamScore();
            if (currGrade >= ninetieth){
                gradeBook.put(s, "A");
            } else if (currGrade >= seventyfirst){
                gradeBook.put(s, "B");
            } else if (currGrade >= fiftieth){
                gradeBook.put(s, "C");
            } else if (currGrade > eleventh){
                gradeBook.put(s, "D");
            } else {
                gradeBook.put(s, "F");
            }
        }
        return gradeBook;
    }
}

class SortByScoreAndLastName implements Comparator<Student>{
    public int compare(Student s1, Student s2){

        //if they're null we'll get a null pointer exception, so do this first?
        if (s1 == null && s2 == null){
            return 0;
        }
        if (s1 == null){
            return 1;
        }
        if (s2 == null){
            return -1;
        }
        //

        double score1 = s1.getAverageExamScore();
        double score2 = s2.getAverageExamScore();
        if (score1 > score2){
            return -1;
        }
        if (score1 < score2){
            return 1;
        }
        if (score1 == score2){
            return s1.getLastName().compareTo(s2.getLastName());
        }
        return 0;
    }
}

class SortByScoreAndLastNameAscending implements Comparator<Student>{
    public int compare(Student s1, Student s2){

        //if they're null we'll get a null pointer exception, so do this first?
        if (s1 == null && s2 == null){
            return 0;
        }
        if (s1 == null){
            return 1;
        }
        if (s2 == null){
            return -1;
        }
        //

        double score1 = s1.getAverageExamScore();
        double score2 = s2.getAverageExamScore();
        if (score1 > score2){
            return 1;
        }
        if (score1 < score2){
            return -1;
        }
        if (score1 == score2){
            return s1.getLastName().compareTo(s2.getLastName());
        }
        return 0;
    }
}

// get all null values to the end of the array
class SortNulls implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        if (s1 == null && s2 == null){
            return 0;
        }
        if (s1 == null){
            return 1;
        }
        if (s2 == null){
            return -1;
        }
        //if neither of them are null, they can stay put
        return 0;
    }
}
