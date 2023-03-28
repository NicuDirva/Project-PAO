package model;
import lombok.*;
import lombok.experimental.SuperBuilder;
import model.enums.Color;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder
public class Car{
    private Integer CarId;
    private Integer DriverId;
    private String Brand;
    private String Model;
    private String IdentificationNumber;

    private Color Color;
    private Integer NumberOfSeats;

}
