package com.example.spring_data_jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides(
        {
                @AttributeOverride(
                        name = "name",
                        column = @Column(name = "guardian_name")
                ),
                @AttributeOverride(
                        name = "name",
                        column = @Column(name = "guardian_email")
                ),
                @AttributeOverride(
                        name = "name",
                        column = @Column(name = "guardian_mobile")
                ),


        }
)
public class Guardian {
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
