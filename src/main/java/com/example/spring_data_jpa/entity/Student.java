package com.example.spring_data_jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "tbl_student",
uniqueConstraints = @UniqueConstraint(
        name = "emaidid_unique",
        columnNames = "email_address"
))
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequnce",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequnce")
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address",
            columnDefinition = "TEXT",
    nullable = false)
    private String emailId;
    @Embedded
   private Guardian guardian;
}
