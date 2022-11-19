package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByEmailId(String emailId);

    //    Spring Repository Definition for finding Records based first name that characracter matches j
//    incuded case not sensitive
    public List<Student> findByFirstNameContainingIgnoreCase(String name);

    //    Return not Null records base on last name
    public List<Student> findByLastNameNotNull();

    //    Return Records base on guardian mobile number
    public List<Student> findByGuardianGuardianMobile(String guardianMobile);

    ////JPQL QUERIES
    ///RETURNING STUDENTS BY EMAIL ADDRESS
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailId(String emailId);

    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentFirstNameEmailId(String emailId);

    //////NATIVE QUERIES
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address=?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);
    //NATIVE QUERY BY SINGLE PARAM
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address =:emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNameParam(
            @Param("emailId") String emailId
    );

    /////UPDATE RECORDS WITH TRANSACTION
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET first_name = ?1 WHERE email_address = ?2",
            nativeQuery = true
    )
    int updateStudentFirstNameByEmailId(String firstName, String emailId);
}
