package com.tse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentRepo {
    private List<Student> studentList;

    public StudentRepo() {
        this.studentList = new ArrayList<>();
    }

    public boolean addStudent(Student student){
        if(studentList.add(student)){
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteStudent(String id){
        for(Student s: studentList){
            if(s.getId().equals(id)){
                studentList.remove(s);
                return true;
            } else {
                throw new NullPointerException("Student id empty! Student does not exist.");
            }
        }
        return false;
    }

    public void retrieveStudentByAge(int age) {
        for(Student s: studentList){
            Date dat = s.parseDate(s.getDate());
            int agee = s.calculateStudentAge(dat);
            if(agee == age){
                System.out.println(s.toString());
            }
        }
    }
}
