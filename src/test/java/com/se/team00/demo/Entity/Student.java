package com.se.team00.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import lombok.*;

import javax.persistence.SequenceGenerator;
import java.lang.annotation.Annotation;
import javax.validation.constraints.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
    @Id
    @Column(unique = true)
    @Pattern(regexp = "^[BMD]\\d{7}")
    private String studentId;

    @NotNull(message = "firstName cannot be null")
    private  String firstName;

    @NotNull(message = "lastName cannot be null")
    private  String lastName;

    public String getStudentId(){
        return studentId;
    }
    
    public void setStudentId( String id ){
        studentId = id;
    } 
    
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName( String first ){
        firstName = first;
    } 
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName( String last ){
        lastName = last;
    } 

} 

