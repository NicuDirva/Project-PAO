package model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder
public class Company {
    private Integer CompanyId;
    private String Name;
    private String FoundationDate;
    private Person President;
    private Integer EmployeesNumber;
    private List<Driver> DriverList;

}
