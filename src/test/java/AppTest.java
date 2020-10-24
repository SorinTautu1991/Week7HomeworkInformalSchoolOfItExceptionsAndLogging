import com.tse.*;
import org.junit.Test;

public class AppTest {


    //this test throws an exception because we are not providing the lastName parameter
    @Test(expected = NullPointerException.class)
    public void testAddStudent() throws GenderException, DateException, IdException {
        StudentRepo s = new StudentRepo();
        s.addStudent(new Student("John", "", "12/02/1991", "male", "1910222128795"));
    }


    @Test(expected = DateException.class)
    public void testDateInvalid() throws GenderException, DateException, IdException{
        StudentRepo s = new StudentRepo();
        s.addStudent(new Student("John", "Doe", "12/1991", "male", "1910222128795"));
    }



    @Test()
    public void testAge() throws GenderException, IdException {
        StudentRepo s = new StudentRepo();
        try{
            s.addStudent(new Student("John", "Doe", "12/02/1965", "male", "1910211343567"));
        }catch (DateException e){
            e.getMessage();
        }
    }


    @Test(expected = GenderException.class)
    public void testGender() throws GenderException, DateException, IdException {
        StudentRepo s = new StudentRepo();
        s.addStudent(new Student("John", "Doe", "12/02/1991", "", "1910229876785"));
    }


    @Test(expected = NullPointerException.class)
    public void deleteStudent() throws GenderException, DateException, IdException {
        StudentRepo s = new StudentRepo();
        s.addStudent(new Student("John", "Doe", "12/02/1991", "male", "1910212123456"));
        s.deleteStudent("");
    }

    @Test
    public void retrieveStudentsWithAgeX() throws GenderException, DateException, IdException {
        StudentRepo s = new StudentRepo();
        s.addStudent(new Student("John", "Doe1", "12/02/1991", "male", "1910212125914"));
        s.addStudent(new Student("Johana", "Doe2", "22/01/1991", "female", "2910122100135"));
        s.addStudent(new Student("John", "Doe3", "19/01/1990", "male", "1910222897656"));
        s.retrieveStudentByAge(29);

    }

}
