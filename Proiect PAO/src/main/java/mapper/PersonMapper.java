package mapper;

import model.Car;
import model.Person;
import model.enums.Color;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonMapper {
    private static final PersonMapper INSTANCE = new PersonMapper();

    private PersonMapper() {
    }

    public static PersonMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Person> mapToPerson(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Person.builder()
                            .PersonId(resultSet.getInt(1))
                            .FirstName(resultSet.getString(2))
                            .LastName(resultSet.getString(3))
                            .DateOfBird(resultSet.getString(4))
                            .Gender(resultSet.getString(5))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Person> mapToPersonList(ResultSet resultSet) throws SQLException {
        List<Person> PersonList = new ArrayList<>();
        while (resultSet.next()) {
            PersonList.add(
                    Person.builder()
                            .PersonId(resultSet.getInt(1))
                            .FirstName(resultSet.getString(2))
                            .LastName(resultSet.getString(3))
                            .DateOfBird(resultSet.getString(4))
                            .Gender(resultSet.getString(5))
                            .build()
            );
        }

        return PersonList;
    }
}
