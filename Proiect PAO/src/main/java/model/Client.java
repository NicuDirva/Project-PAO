package model;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@SuperBuilder
public class Client extends Person{
    private Integer ClientId;
    private Integer PersonId;
    private String PhoneNumber;

    private String Mail;

    public Client(Integer PersonId, String FirstName, String LastName, String DateOfBird, String Gender, Integer clientId, String phoneNumber, String mail) {
        super(PersonId, FirstName, LastName, DateOfBird, Gender);
        ClientId = clientId;
        PhoneNumber = phoneNumber;
        Mail = mail;
    }


}
