package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.Guardian;
import com.example.spring_data_jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("joshuap@gmail.com")
                .firstName("Joshua")
                .lastName("Kiptoo")
//                .guardianName("Collins Kibet")
//                .guardianEmail("kibet@gmail.com")
//                .guardianMobile("+252721845120")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .guardianName("JAMES ROICH")
                .guardianEmail("JAMES@GMAIL.COM")
                .guardianMobile("+254700000004")
                .build();
        Student student = Student.builder()
                .emailId("JAMES@GMAIL.COM.com")
                .firstName("JAMES")
                .lastName("MWANGI")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

    }
    @Test
    public void getAllStudents(){
        List<Student> studentList =
        studentRepository.findAll();
        System.out.println("Students Available:" + studentList);
    }
    @Test
    public void printStudentByEmailId(){
        List<Student> students = studentRepository.findByEmailId("joshua@gmail.com");
        System.out.println("Student By Email:" + students);
    }
    @Test
    public void printStudentByFirstName(){
        List<Student> studentsByFirstName = studentRepository.findByFirstNameContainingIgnoreCase("j");
        System.out.println("Student By First Name:" + studentsByFirstName);
    }
    @Test
    public void printStudentByLastNameNotNull(){
        List<Student> studentsByLastNameNotNull = studentRepository.findByLastNameNotNull();
        System.out.println("Student By Last Name Not Null:" + studentsByLastNameNotNull);
    }
    @Test
    public void printStudentWithGuardianMobile(){
        List<Student> studentsWithGuardianMobile = studentRepository.findByGuardianGuardianMobile("+254700000001");
        System.out.println("Student With Guardian By Mobile:" + studentsWithGuardianMobile);
    }
    //Test from JPQL QUERIES
    @Test
    public void printGetStudentByEmailId(){
       Student students = studentRepository.getStudentByEmailId(
               "joshua@gmail.com");
        System.out.println("Get Student Email Found:" + students);
    }

    @Test
    public void printGetStudentFirstNameEmailId(){
      String  firstname = studentRepository.getStudentFirstNameEmailId("joshua@gmail.com");
        System.out.println("Student First Name BY Email Found:" + firstname);
    }
    ////NATIVE QUERIES
    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative(
                "joshua@gmail.com");
        System.out.println("Get Student BY Email(NATIVE):" + student);
    }
    @Test
    public void getStudentByEmailAddressNativeNameParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNameParam(
                "joshua@gmail.com");
        System.out.println("Get Student BY Email(NATIVE PARAM):" + student);

    }

    ///UPDATING RECORDS
    @Test
    public void updateStudentFirstNameByEmailId(){
        studentRepository.updateStudentFirstNameByEmailId(
                "DAVID",
                "joshua@gmail.com");
    }

}
