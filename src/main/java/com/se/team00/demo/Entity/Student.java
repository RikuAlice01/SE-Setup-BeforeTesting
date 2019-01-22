package com.se.team00.demo.Entity;

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

} 