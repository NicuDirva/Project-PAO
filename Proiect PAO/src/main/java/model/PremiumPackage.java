package model;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder
public class PremiumPackage {
    private Integer PackageId;
    private Integer ClientId;
    public String ValidityPeriod;
    public Double Price;

}
