package model;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder
public class Location {
    private Integer LocationId;
    private String City;

    private String Street;

    private Integer Number;

}
