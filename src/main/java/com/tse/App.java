package com.tse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    static final Logger logger = LogManager.getLogger(App.class.getName());

    public static void main( String[] args ) {
        StudentRepo s = new StudentRepo();
        try{
            System.out.println(s.addStudent(new Student("John", "Doe1", "12/02/1991", "male", "1910212125914")));
            System.out.println(s.addStudent(new Student("Johana", "Doe2", "22/01/1991", "female", "2910122100135")));
            System.out.println(s.addStudent(new Student("John", "Doe3", "19/01/", "male", "1910222897656")));
            s.retrieveStudentByAge(29);
            s.deleteStudent("1910212125914");
        }catch (DateException e1){
            logger.error(e1.getMessage());
        }catch(IdException e2){
            logger.error(e2.getMessage());
        }catch(GenderException e3){
            logger.error(e3.getMessage());
        }catch(NullPointerException e4){
            logger.error(e4.getMessage());
        }
    }
}
