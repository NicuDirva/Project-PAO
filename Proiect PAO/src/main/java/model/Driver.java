package model;

import java.util.Set;
import lombok.*;
import lombok.experimental.SuperBuilder;
import model.enums.DriverLicence;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@SuperBuilder
public class Driver extends Person{

    private Integer DriverId;
    private Integer PersonId;
    private String PhoneNumber;

    private String Mail;

    private String DriverLicenceDate;
    private Set<DriverLicence> DriverLicence;

    public Driver(Integer PersonId, String FirstName, String LastName, String DateOfBird, String Gender, Integer driverId, Integer personId, String phoneNumber, String mail, String driverLicenceDate, Set<model.enums.DriverLicence> driverLicence) {
        super(PersonId, FirstName, LastName, DateOfBird, Gender);
        DriverId = driverId;
        PhoneNumber = phoneNumber;
        Mail = mail;
        DriverLicenceDate = driverLicenceDate;
        DriverLicence = driverLicence;
    }
}
