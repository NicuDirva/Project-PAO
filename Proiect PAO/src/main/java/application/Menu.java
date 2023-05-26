package application;

import Repository.impl.CarRepositoyImpl;
import Repository.impl.ClientRepositoryImpl;
import Repository.impl.LocationRepositoryImpl;
import Repository.impl.PersonRepositoryImpl;
import csv.CsvWriter;
import model.Car;
import model.Client;
import model.Location;
import model.Person;
import model.enums.Color;
import service.CarService;
import service.ClientService;
import service.LocationService;
import service.PersonService;
import service.impl.CarServiceImpl;
import service.impl.ClientServiceImpl;
import service.impl.LocationServiceImpl;
import service.impl.PersonServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Menu {

    static final CsvWriter CSV_WRITER = CsvWriter.getInstance();
    private static final Logger LOGGER = Logger.getLogger(Menu.class.getName());
    static Menu INSTANCE;
    CarService carService;
    PersonService personService;
    ClientService clientService;
    LocationService locationService;

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public Menu() {
        carService = new CarServiceImpl(new CarRepositoyImpl());
        personService = new PersonServiceImpl(new PersonRepositoryImpl());
        clientService = new ClientServiceImpl(new ClientRepositoryImpl());
        locationService = new LocationServiceImpl(new LocationRepositoryImpl());
    }

    void cout(Object line) {
        System.out.println(line);
    }

    public void intro() {

        List<String[]> lines = new ArrayList<>();


        boolean glb = true;
        while (glb) {
            cout("************************************************************************************************************************\\n");
            cout("Choose an option: \n\n");
            cout("1 - Client operation\n");
            cout("2 - Car operation\n");
            cout("3 - Location operation\n");
            cout("4 - Person operation\n");
            cout("5 - Exit\n");
            cout("Read the number associated with the desire option: ");

            int choice = new Scanner(System.in).nextInt();


            cout("\n\n");
            cout("************************************************************************************************************************\n\n");

            switch (choice) {
                case 1 -> {
                    String[] line = new String[]{"Client operation", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm:ss"))};
                    lines.add(line);
                    try {
                        CSV_WRITER.writeLines(lines);
                    } catch (Exception ignored) {

                    }
                }
                case 2 -> {
                    String[] line2 = new String[]{"Car operation", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm:ss"))};
                    lines.add(line2);
                    try {
                        CSV_WRITER.writeLines(lines);
                    } catch (Exception ignored) {

                    }
                }
                case 3 -> {
                    String[] line3 = new String[]{"Location operation", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm:ss"))};
                    lines.add(line3);
                    try {
                        CSV_WRITER.writeLines(lines);
                    } catch (Exception ignored) {

                    }
                }
                case 4 -> {
                    String[] line4 = new String[]{"Person operation", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm:ss"))};
                    lines.add(line4);
                    try {
                        CSV_WRITER.writeLines(lines);
                    } catch (Exception ignored) {

                    }
                }
            }
            boolean bool_client = true, bool_car = true, bool_location = true, bool_person = true;

            if (choice == 1) {
                while (bool_client) {
                    cout("************************************************************************************************************************\\n");
                    cout("Choose an option: \n\n");
                    cout("1 - Add a client\n");
                    cout("2 - Display o client by id\n");
                    cout("3 - Display all clients\n");
                    cout("4 - Modify a client\n");
                    cout("5 - Delete a client\n");
                    cout("6 - Back\n");
                    cout("Read the number associated with the desire option: ");

                    int choice_client_1 = new Scanner(System.in).nextInt();

                    cout("\n\n");
                    cout("************************************************************************************************************************\n\n");


                    if (choice_client_1 == 1) {
                        cout("Personal id (Integer): ");
                        Integer personal_id_c = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        Scanner str37 = new Scanner(System.in);
                        String client_fn = str37.nextLine();
                        cout("Last name (String): ");
                        Scanner str38 = new Scanner(System.in);
                        String client_ln = str38.nextLine();
                        cout("Date of bird (String): ");
                        Scanner str39 = new Scanner(System.in);
                        String client_date = str39.nextLine();
                        cout("Gender (String): ");
                        Scanner str40 = new Scanner(System.in);
                        String gender_c = str40.nextLine();
                        cout("Client id (Integer): ");
                        Integer client_id = new Scanner(System.in).nextInt();
                        cout("Phone Number (String): ");
                        Scanner str41 = new Scanner(System.in);
                        String phoneNumber = str41.nextLine();
                        cout("Mail (String): ");
                        Scanner str42 = new Scanner(System.in);
                        String mail = str42.nextLine();

                        Client client = new Client(personal_id_c, client_fn, client_ln, client_date, gender_c, client_id, phoneNumber, mail);
                        clientService.addOnlyOne(client);
                    }
                    if (choice_client_1 == 2) {
                        cout("Id client:");
                        Integer Id_c = new Scanner(System.in).nextInt();
                        Optional<Client> client_aff = clientService.getById(Id_c);

                        if (client_aff.isPresent()) {

                            cout("************************************************************************************************************************\n\n");
                            cout(client_aff);
                            cout("************************************************************************************************************************\n\n");

                        } else {
                            cout("Id does't exist!");
                        }
                    }
                    if (choice_client_1 == 3) {
                        List<Client> list = clientService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Client cl : list) {
                            cout(cl);
                        }
                        cout("************************************************************************************************************************\n\n");
                    }
                    if (choice_client_1 == 4) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer id_m = new Scanner(System.in).nextInt();
                        cout("Read new date:");
                        cout("Personal id (Integer): ");
                        Integer new_personal_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        Scanner str43 = new Scanner(System.in);
                        String new_fn = str43.nextLine();
                        cout("Last name (String): ");
                        Scanner str44 = new Scanner(System.in);
                        String new_ln = str44.nextLine();
                        cout("Date of bird (String): ");
                        Scanner str45 = new Scanner(System.in);
                        String new_persona_date = str45.nextLine();
                        cout("Gender (String): ");
                        Scanner str46 = new Scanner(System.in);
                        String new_gender = str46.nextLine();
                        cout("Client id (Integer): ");
                        Integer new_client_id = new Scanner(System.in).nextInt();
                        cout("Phone Number (String): ");
                        Scanner str47 = new Scanner(System.in);
                        String new_phoneNumber = str47.nextLine();
                        cout("Mail (String): ");
                        Scanner str48 = new Scanner(System.in);
                        String new_mail = str48.nextLine();

                        Client client_m = new Client(new_personal_id, new_fn, new_ln, new_persona_date, new_gender, new_client_id, new_phoneNumber, new_mail);
                        clientService.modifyById(id_m, client_m);
                        cout("************************************************************************************************************************\n\n");

                    }
                    if (choice_client_1 == 5) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer id_d = new Scanner(System.in).nextInt();
                        clientService.removeById(id_d);
                        cout("************************************************************************************************************************\n\n");
                    }


                    if (choice_client_1 == 6) {
                        bool_client = false;
                    }
                }
            }

            if (choice == 2) {
                while (bool_car) {
                    cout("************************************************************************************************************************\\n");
                    cout("Choose an option: \n\n");
                    cout("1 - Add a car\n");
                    cout("2 - Display o car by id\n");
                    cout("3 - Display all cars\n");
                    cout("4 - Modify a car\n");
                    cout("5 - Delete a car\n");
                    cout("6 - Back\n");
                    cout("Read the number associated with the desire option: ");

                    int choice_car_1 = new Scanner(System.in).nextInt();

                    cout("\n\n");
                    cout("************************************************************************************************************************\n\n");

                    if (choice_car_1 == 1) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Car id (Integer): ");
                        Integer car_id = new Scanner(System.in).nextInt();
                        cout("Driver id (Integer): ");
                        Integer driver_id = new Scanner(System.in).nextInt();
                        cout("Brand (String): ");
                        Scanner str70 = new Scanner(System.in);
                        String brand = str70.nextLine();
                        cout("Model (String): ");
                        Scanner str71 = new Scanner(System.in);
                        String model = str71.nextLine();
                        cout("IdentificationNumber (String): ");
                        Scanner str72 = new Scanner(System.in);
                        String identificationNumber = str72.nextLine();
                        cout("Color (String): ");
                        Scanner str73 = new Scanner(System.in);
                        String color = str73.nextLine();
                        Color real_color = switch (color) {
                            case "WHITE" -> Color.WHITE;
                            case "BLACK" -> Color.BLACK;
                            case "RED" -> Color.RED;
                            case "BLUE" -> Color.BLUE;
                            case "YELLOW" -> Color.YELLOW;
                            case "GREEN" -> Color.GREEN;
                            case "PURPLE" -> Color.PURPLE;
                            case "BROWN" -> Color.BROWN;
                            case "GREY" -> Color.GREY;
                            case "PINK" -> Color.PINK;
                            default -> null;
                        };
                        cout("Number of seats (Integer): ");
                        Integer nr = new Scanner(System.in).nextInt();
                        Car car = new Car(car_id, driver_id, brand, model, identificationNumber, real_color, nr);
                        carService.addOnlyOne(car);
                        cout("************************************************************************************************************************\n\n");
                    }


                    if (choice_car_1 == 2) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Id car:");
                        Integer Id_c = new Scanner(System.in).nextInt();
                        Optional<Car> car_aff = carService.getById(Id_c);

                        if (car_aff.isPresent()) {

                            cout("************************************************************************************************************************\n\n");
                            cout(car_aff);
                            cout("************************************************************************************************************************\n\n");

                        } else {
                            cout("Id does't exist!");
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_car_1 == 3) {
                        List<Car> list = carService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Car cr : list) {
                            cout(cr);
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_car_1 == 4) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Car id (Integer): ");
                        Integer id_c = new Scanner(System.in).nextInt();
                        cout("Read new date:");
                        cout("Car id (Integer): ");
                        Integer new_car_id = new Scanner(System.in).nextInt();
                        cout("Driver id (Integer): ");
                        Integer new_driver_id = new Scanner(System.in).nextInt();
                        cout("Brand (String): ");
                        Scanner str74 = new Scanner(System.in);
                        String new_brand = str74.nextLine();
                        cout("Model (String): ");
                        Scanner str75 = new Scanner(System.in);
                        String new_model = str75.nextLine();
                        cout("IdentificationNumber (String): ");
                        Scanner str76 = new Scanner(System.in);
                        String new_identificationNumber = str76.nextLine();
                        cout("Color (String): ");
                        Scanner str77 = new Scanner(System.in);
                        String new_color = str77.nextLine();
                        Color new_real_color = switch (new_color) {
                            case "WHITE" -> Color.WHITE;
                            case "BLACK" -> Color.BLACK;
                            case "RED" -> Color.RED;
                            case "BLUE" -> Color.BLUE;
                            case "YELLOW" -> Color.YELLOW;
                            case "GREEN" -> Color.GREEN;
                            case "PURPLE" -> Color.PURPLE;
                            case "BROWN" -> Color.BROWN;
                            case "GREY" -> Color.GREY;
                            case "PINK" -> Color.PINK;
                            default -> null;
                        };
                        cout("Number of seats (Integer): ");
                        Integer new_nr = new Scanner(System.in).nextInt();
                        Car new_car = new Car(new_car_id, new_driver_id, new_brand, new_model, new_identificationNumber, new_real_color, new_nr);
                        carService.modifyById(id_c, new_car);
                        cout("************************************************************************************************************************\n\n");
                    }
                    if (choice_car_1 == 5) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Car id (Integer): ");
                        Integer id_ca = new Scanner(System.in).nextInt();
                        carService.removeById(id_ca);
                        cout("************************************************************************************************************************\n\n");

                    }

                    if (choice_car_1 == 6) {
                        bool_car = false;
                    }
                }
            }

            if (choice == 3) {
                while (bool_location) {
                    cout("************************************************************************************************************************\\n");
                    cout("Choose an option: \n\n");
                    cout("1 - Add a location\n");
                    cout("2 - Display o location by id\n");
                    cout("3 - Display all locations\n");
                    cout("4 - Modify a location\n");
                    cout("5 - Delete a location\n");
                    cout("6 - Back\n");
                    cout("Read the number associated with the desire option: ");

                    int choice_location_1 = new Scanner(System.in).nextInt();

                    cout("\n\n");
                    cout("************************************************************************************************************************\n\n");


                    if (choice_location_1 == 1) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Location id (Integer): ");
                        Integer id_l = new Scanner(System.in).nextInt();
                        cout("City (String): ");
                        Scanner str79 = new Scanner(System.in);
                        String city = str79.nextLine();
                        cout("Street (String): ");
                        Scanner str80 = new Scanner(System.in);
                        String street = str80.nextLine();
                        cout("Number (Integer): ");
                        Integer number = new Scanner(System.in).nextInt();

                        Location loc = new Location(id_l, city, street, number);
                        locationService.addOnlyOne(loc);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_location_1 == 2) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Id location:");
                        Integer Id_l = new Scanner(System.in).nextInt();
                        Optional<Location> loc_aff = locationService.getById(Id_l);

                        if (loc_aff.isPresent()) {

                            cout("************************************************************************************************************************\n\n");
                            cout(loc_aff);
                            cout("************************************************************************************************************************\n\n");

                        } else {
                            cout("Id does't exist!");
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_location_1 == 3) {
                        List<Location> list = locationService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Location locc : list) {
                            cout(locc);
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_location_1 == 4) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Location id (Integer): ");
                        Integer id_ll = new Scanner(System.in).nextInt();
                        cout("Read new date:");
                        cout("Location id (Integer): ");
                        Integer new_id_l = new Scanner(System.in).nextInt();
                        cout("City (String): ");
                        Scanner str81 = new Scanner(System.in);
                        String new_city = str81.nextLine();
                        cout("Street (String): ");
                        Scanner str82 = new Scanner(System.in);
                        String new_street = str82.nextLine();
                        cout("Number (Integer): ");
                        Integer new_number = new Scanner(System.in).nextInt();

                        Location new_loc = new Location(new_id_l, new_city, new_street, new_number);
                        locationService.modifyById(id_ll, new_loc);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_location_1 == 5) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Location id (Integer): ");
                        Integer id_lll = new Scanner(System.in).nextInt();
                        locationService.removeById(id_lll);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_location_1 == 6) {
                        bool_location = false;
                    }
                }
            }

            if (choice == 4) {
                while (bool_person) {
                    cout("************************************************************************************************************************\\n");
                    cout("Choose an option: \n\n");
                    cout("1 - Add a person\n");
                    cout("2 - Display o person by id\n");
                    cout("3 - Display all persons\n");
                    cout("4 - Modify a person\n");
                    cout("5 - Delete a person\n");
                    cout("6 - Back\n");
                    cout("Read the number associated with the desire option: ");

                    int choice_person_1 = new Scanner(System.in).nextInt();

                    cout("\n\n");
                    cout("************************************************************************************************************************\n\n");

                    if (choice_person_1 == 1) {
                        cout("Personal id (Integer): ");
                        Integer person_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        Scanner str92 = new Scanner(System.in);
                        String person_fn = str92.nextLine();
                        cout("Last name (String): ");
                        Scanner str93 = new Scanner(System.in);
                        String person_ln = str93.nextLine();
                        cout("Date of bird (String): ");
                        Scanner str94 = new Scanner(System.in);
                        String person_date = str94.nextLine();
                        cout("Gender (String): ");
                        Scanner str95 = new Scanner(System.in);
                        String gender_p = str95.nextLine();

                        Person person = new Person(person_id, person_fn, person_ln, person_date, gender_p);
                        personService.addOnlyOne(person);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_person_1 == 2) {
                        cout("Person Id:");
                        Integer Id_p = new Scanner(System.in).nextInt();
                        Optional<Person> person_aff = personService.getById(Id_p);

                        if (person_aff.isPresent()) {

                            cout("************************************************************************************************************************\n\n");
                            cout(person_aff);
                            cout("************************************************************************************************************************\n\n");

                        } else {
                            cout("Id does't exist!");
                        }
                    }

                    if (choice_person_1 == 3) {
                        List<Person> list = personService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Person per : list) {
                            cout(per);
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_person_1 == 4) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer id_read = new Scanner(System.in).nextInt();
                        cout("Read new date:");
                        cout("Personal id (Integer): ");
                        Integer new_person_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        Scanner str96 = new Scanner(System.in);
                        String new_person_fn = str96.nextLine();
                        cout("Last name (String): ");
                        Scanner str97 = new Scanner(System.in);
                        String new_person_ln = str97.nextLine();
                        cout("Date of bird (String): ");
                        Scanner str98 = new Scanner(System.in);
                        String new_person_date = str98.nextLine();
                        cout("Gender (String): ");
                        Scanner str99 = new Scanner(System.in);
                        String new_gender_p = str99.nextLine();

                        Person newPerson = new Person(new_person_id, new_person_fn, new_person_ln, new_person_date, new_gender_p);
                        personService.modifyById(id_read, newPerson);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_person_1 == 5) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Person id (Integer): ");
                        Integer id_pp = new Scanner(System.in).nextInt();
                        personService.removeById(id_pp);
                        cout("************************************************************************************************************************\n\n");

                    }
                    if (choice_person_1 == 6) {
                        bool_person = false;
                    }


                }
            }

            if (choice == 5) {
                LOGGER.log(Level.INFO, "La revedere");
                glb = false;
            }


        }
    }

}
