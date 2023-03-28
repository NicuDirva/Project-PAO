package model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder
public class Person {
    private Integer PersonId;
    private String FirstName;

    private String LastName;

    private String DateOfBird;

    private String Gender;


}
