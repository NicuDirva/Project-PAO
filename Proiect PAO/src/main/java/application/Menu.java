package application;

import model.*;
import model.enums.Color;
import model.enums.DrivingLicenceCategories;
import service.*;
import service.impl.*;

import service.CarService;
import service.impl.CarServiceImpl;

import java.util.*;


public class Menu {

    private static Menu INSTANCE;
    private final CarService carService = new CarServiceImpl();
    private final ClientService clientService = new ClientServiceImpl();
    private final CompanyService companyService = new CompanyServiceImpl();
    private final DiscountCouponService discountCouponService = new DiscountCouponServiceImpl();
    private final DriverService driverService = new DriverServiceImpl();
    private final LocationService locationService = new LocationServiceImpl();
    private final OrderReviewService orderReviewService = new OrderReviewImpl();
    private final OrderService orderService = new OrderServiceImpl();
    private final PersonService personService = new PersonServiceImpl();
    private final PremiumPackageService premiumPackageService = new PremiumPackageServiceImpl();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    private Menu() {}

    void cout(Object line) {
        System.out.println(line);
    }

    public void intro() {
        /*Car car = Car.builder()
                .CarId(1)
                .Brand("BMW") // data de azi
                .Model("e46")
                .IdentificationNumber("TR96MDL")
                .Color(Color.RED)
                .NumberOfSeats(4)
                .build();
        //System.out.println(car);
        Car car2 = Car.builder()
                .CarId(2)
                .Brand("BMW") // data de azi
                .Model("e46")
                .IdentificationNumber("TR05GZO")
                .Color(Color.BLACK)
                .NumberOfSeats(4)
                .build();

        carService.addOnlyOne(car);
        carService.modifyById(1, car2);
        List<Car> list_car = carService.getAll();
        //carService.getAllCar();
        for(Car carr:list_car) {
            System.out.println(carr);


        Set<DriverLicence> licence_dr1 = new HashSet<>(Arrays.asList(DriverLicence.A, DriverLicence.B));
        Driver d1 = Driver.builder()
                .DriverId(1)
                .PersonId(1)
                .PhoneNumber("07777")
                .Mail("primul_creat")
                .DriverLicenceDate("01042002")
                .DriverLicence(licence_dr1)
                .build();
        Set<DriverLicence> licence_dr2 = new HashSet<>(Arrays.asList(DriverLicence.A, DriverLicence.B, DriverLicence.A2, DriverLicence.B1));
        Driver d2 = Driver.builder()
                .DriverId(2)
                .PersonId(2)
                .PhoneNumber("07557")
                .Mail("al_doile_creat")
                .DriverLicenceDate("01042002")
                .DriverLicence(licence_dr2)
                .build();
        Set<DriverLicence> licence_dr3 = new HashSet<>(Arrays.asList(DriverLicence.A, DriverLicence.B, DriverLicence.B1));
        Driver d3 = Driver.builder()
                .DriverId(2)
                .PersonId(2)
                .PhoneNumber("07557")
                .Mail("al_treilea_creat")
                .DriverLicenceDate("01042002")
                .DriverLicence(licence_dr3)
                .build();
        List<Driver> list1 = new ArrayList<>();
        list1.add(d1);
        list1.add(d2);
        list1.add(d3);
        Person p1 = Person.builder()
                .PersonId(1)
                .FirstName("Nicu")
                .LastName("Dirva")
                .DateOfBird("010101")
                .Gender("Male")
                .build();
        Company c1 = Company.builder()
                .CompanyId(1)
                .Name("Compnia 1")
                .FoundationDate("010219000")
                .President(p1)
                .EmployeesNumber(120)
                .DriverList(list1)
                .build();
        companyService.addOnlyOne(c1);
        companyService.sortDrivers(1);
        for(Company c : companyService.getAll()) {
            for (Driver driver : c.getDriverList()) {
                System.out.println(driver.getMail());
            }

        }
        */
        cout("************************************************************************************************************************\\n");
        cout("Choose an option: \n\n");
        cout("1 - Company operation\n");
        cout("2 - Client operation\n");
        cout("3 - Driver operation\n");
        cout("4 - Car operation\n");
        cout("5 - Location operation\n");
        cout("6 - Order operation\n");
        cout("7 - OrderReview operation\n");
        cout("8 - PremiumPackage operation\n");
        cout("8 - Exit\n");
        cout("Read the number associated with the desire option: ");

        int choice = new Scanner(System.in).nextInt();

        cout("\n\n");
        cout("************************************************************************************************************************\n\n");

        switch (choice) {
            case 1:
                cout("************************************************************************************************************************\\n");
                cout("Choose an option: \n\n");
                cout("1 - Add a company\n");
                cout("2 - Display o company by id\n");
                cout("3 - Display all companies\n");
                cout("4 - Modify a company\n");
                cout("5 - Delete a company\n");
                cout("6 - Back\n");
                cout("Read the number associated with the desire option: ");

                int choice_company_1 = new Scanner(System.in).nextInt();

                cout("\n\n");
                cout("************************************************************************************************************************\n\n");

                switch (choice_company_1) {
                    case 1:
                        cout("************************************************************************************************************************\\n");
                        cout("Company id (Integer): ");
                        Integer Id = new Scanner(System.in).nextInt();
                        cout("Company name (String): ");
                        String name = String.valueOf(new Scanner(System.in));
                        cout("The date of establishment  of the company (String): ");
                        String date = String.valueOf(new Scanner(System.in));

                        Person owner;

                        cout("Information about the owner of the company");
                        cout("Personal id (Integer): ");
                        Integer owner_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        String owner_fn = String.valueOf(new Scanner(System.in));
                        cout("Last name (String): ");
                        String owner_ln = String.valueOf(new Scanner(System.in));
                        cout("Date of bird (String): ");
                        String owner_date = String.valueOf(new Scanner(System.in));
                        cout("Gender (String): ");
                        String gender = String.valueOf(new Scanner(System.in));
                        owner = new Person(owner_id, owner_fn, owner_ln, owner_date, gender);


                        cout("The number of employees in the company(String): ");
                        Integer employeesnumber = new Scanner(System.in).nextInt();

                        List<Driver> driverList = null;

                        cout("The number of drivers in the company: ");
                        Integer driversnumber = new Scanner(System.in).nextInt();
                        for (int i = 0; i < driversnumber; i++) {
                            cout("Personal id (Integer): ");
                            Integer personal_id = new Scanner(System.in).nextInt();
                            cout("First name (String): ");
                            String driver_fn = String.valueOf(new Scanner(System.in));
                            cout("Last name (String): ");
                            String driver_ln = String.valueOf(new Scanner(System.in));
                            cout("Date of bird (String): ");
                            String driver_date = String.valueOf(new Scanner(System.in));
                            cout("Gender (String): ");
                            String gender_d = String.valueOf(new Scanner(System.in));
                            cout("Driver id (Integer): ");
                            Integer driver_id = new Scanner(System.in).nextInt();
                            cout("Phone Number (String): ");
                            String phoneNumber = String.valueOf(new Scanner(System.in));
                            cout("Mail (String): ");
                            String mail = String.valueOf(new Scanner(System.in));
                            cout("Driver licence date (String): ");
                            String driverLicenceDate = String.valueOf(new Scanner(System.in));

                            driverList = new ArrayList<>();

                            Set<DrivingLicenceCategories> drivingLicenceCategories = new HashSet<>();
                            cout("The number of driving licence categories: ");
                            Integer numberLicenceCategories = new Scanner(System.in).nextInt();

                            for (int j = 0; j < numberLicenceCategories; j++) {
                                String cat = String.valueOf(new Scanner(System.in));
                                    switch (cat) {
                                        case "AM":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.AM);
                                            break;
                                        case "A1":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.A1);
                                            break;
                                        case "A2":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.A2);
                                            break;
                                        case "A":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.A);
                                            break;
                                        case "B":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.B);
                                            break;
                                        case "B1":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.B1);
                                            break;
                                        case "BE":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.BE);
                                            break;
                                        case "C1":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.C1);
                                            break;
                                        case "C1E":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.C1E);
                                            break;
                                        case "C":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.C);
                                            break;
                                        case "CE":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.CE);
                                            break;
                                        case "D1":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.D1);
                                            break;
                                        case "D1E":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.D1E);
                                            break;
                                        case "D":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.D);
                                            break;
                                        case "DE":
                                            drivingLicenceCategories.add(DrivingLicenceCategories.DE);
                                            break;
                                    }
                            }
                            Driver driver = new Driver(personal_id, driver_fn, driver_ln, driver_date, gender_d, driver_id, phoneNumber, mail, driverLicenceDate, drivingLicenceCategories);
                            driverList.add(driver);
                        }


                        Company company = new Company(Id, name, date, owner, employeesnumber, driverList);
                        companyService.addOnlyOne(company);
                        cout("************************************************************************************************************************\n\n");
                        break;

                    case 2:
                        cout("************************************************************************************************************************\n\n");

                        cout("Id company:");
                        Integer Id_c = new Scanner(System.in).nextInt();
                        Optional <Company> company_aff = companyService.getById(Id_c);

                        if(company_aff.isPresent()) {

                            cout("************************************************************************************************************************\n\n");
                            cout(company_aff);
                            cout("************************************************************************************************************************\n\n");

                        }
                        else {
                            cout("Id does't exist!");
                        }
                        cout("************************************************************************************************************************\n\n");

                        break;

                    case 3:
                        List<Company> list = companyService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Company cp : list) {
                            cout(cp);
                        }
                        cout("************************************************************************************************************************\n\n");
                        break;

                    case 4:
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer id_m = new Scanner(System.in).nextInt();
                        cout("Read new date:");cout("Company id (Integer): ");
                        Integer new_Id = new Scanner(System.in).nextInt();
                        cout("Company name (String): ");
                        String new_name = String.valueOf(new Scanner(System.in));
                        cout("The date of establishment  of the company (String): ");
                        String new_date = String.valueOf(new Scanner(System.in));

                        Person new_owner;

                        cout("Information about the owner of the company");
                        cout("Personal id (Integer): ");
                        Integer new_owner_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        String new_owner_fn = String.valueOf(new Scanner(System.in));
                        cout("Last name (String): ");
                        String new_owner_ln = String.valueOf(new Scanner(System.in));
                        cout("Date of bird (String): ");
                        String new_owner_date = String.valueOf(new Scanner(System.in));
                        cout("Gender (String): ");
                        String new_gender = String.valueOf(new Scanner(System.in));
                        new_owner = new Person(new_owner_id, new_owner_fn,new_owner_ln, new_owner_date, new_gender);


                        cout("The number of employees in the company(String): ");
                        Integer new_employeesnumber = new Scanner(System.in).nextInt();

                        List<Driver> new_driverList = null;

                        cout("The number of drivers in the company: ");
                        Integer new_driversnumber = new Scanner(System.in).nextInt();
                        for (int i = 0; i < new_driversnumber; i++) {
                            cout("Personal id (Integer): ");
                            Integer personal_id = new Scanner(System.in).nextInt();
                            cout("First name (String): ");
                            String driver_fn = String.valueOf(new Scanner(System.in));
                            cout("Last name (String): ");
                            String driver_ln = String.valueOf(new Scanner(System.in));
                            cout("Date of bird (String): ");
                            String driver_date = String.valueOf(new Scanner(System.in));
                            cout("Gender (String): ");
                            String gender_d = String.valueOf(new Scanner(System.in));
                            cout("Driver id (Integer): ");
                            Integer driver_id = new Scanner(System.in).nextInt();
                            cout("Phone Number (String): ");
                            String phoneNumber = String.valueOf(new Scanner(System.in));
                            cout("Mail (String): ");
                            String mail = String.valueOf(new Scanner(System.in));
                            cout("Driver licence date (String): ");
                            String driverLicenceDate = String.valueOf(new Scanner(System.in));


                            Set<DrivingLicenceCategories> drivingLicenceCategories = new HashSet<>();
                            cout("The number of driving licence categories: ");
                            Integer numberLicenceCategories = new Scanner(System.in).nextInt();

                            for (int j = 0; j < numberLicenceCategories; j++) {
                                String cat = String.valueOf(new Scanner(System.in));
                                switch (cat) {
                                    case "AM":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.AM);
                                        break;
                                    case "A1":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.A1);
                                        break;
                                    case "A2":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.A2);
                                        break;
                                    case "A":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.A);
                                        break;
                                    case "B":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.B);
                                        break;
                                    case "B1":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.B1);
                                        break;
                                    case "BE":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.BE);
                                        break;
                                    case "C1":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.C1);
                                        break;
                                    case "C1E":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.C1E);
                                        break;
                                    case "C":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.C);
                                        break;
                                    case "CE":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.CE);
                                        break;
                                    case "D1":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.D1);
                                        break;
                                    case "D1E":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.D1E);
                                        break;
                                    case "D":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.D);
                                        break;
                                    case "DE":
                                        drivingLicenceCategories.add(DrivingLicenceCategories.DE);
                                        break;
                                }
                            }
                            Driver driver = new Driver(personal_id, driver_fn, driver_ln, driver_date, gender_d, driver_id, phoneNumber, mail, driverLicenceDate, drivingLicenceCategories);
                            new_driverList.add(driver);
                        }



                        Company new_company = new Company(new_Id, new_name, new_date, new_owner, new_employeesnumber, new_driverList);
                        companyService.modifyById(id_m, new_company);
                        cout("************************************************************************************************************************\n\n");
                        break;

                    case 5:
                        cout("************************************************************************************************************************\n\n");

                        cout("Company id (Integer): ");
                        Integer id_c = new Scanner(System.in).nextInt();
                        companyService.removeById(id_c);
                        cout("************************************************************************************************************************\n\n");
                        break;

                    case 6:
                        break;




                }
            case 2:
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

                switch (choice_client_1) {
                    case 1:
                        cout("Personal id (Integer): ");
                        Integer personal_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        String client_fn = String.valueOf(new Scanner(System.in));
                        cout("Last name (String): ");
                        String client_ln = String.valueOf(new Scanner(System.in));
                        cout("Date of bird (String): ");
                        String client_date = String.valueOf(new Scanner(System.in));
                        cout("Gender (String): ");
                        String gender_c = String.valueOf(new Scanner(System.in));
                        cout("Client id (Integer): ");
                        Integer client_id = new Scanner(System.in).nextInt();
                        cout("Phone Number (String): ");
                        String phoneNumber = String.valueOf(new Scanner(System.in));
                        cout("Mail (String): ");
                        String mail = String.valueOf(new Scanner(System.in));

                        Client client = new Client(personal_id, client_fn, client_ln, client_date, gender_c, client_id, phoneNumber, mail);
                        clientService.addOnlyOne(client);
                        break;
                    case 2:
                        cout("Id client:");
                        Integer Id_c = new Scanner(System.in).nextInt();
                        Optional <Client> client_aff = clientService.getById(Id_c);

                        if(client_aff.isPresent()) {

                            cout("************************************************************************************************************************\n\n");
                            cout(client_aff);
                            cout("************************************************************************************************************************\n\n");

                        }
                        else {
                            cout("Id does't exist!");
                        }
                        break;
                    case 3:
                        List<Client> list = clientService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Client cl : list) {
                            cout(cl);
                        }
                        cout("************************************************************************************************************************\n\n");
                        break;
                    case 4:
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer id_m = new Scanner(System.in).nextInt();
                        cout("Read new date:");
                        cout("Personal id (Integer): ");
                        Integer new_personal_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        String new_fn = String.valueOf(new Scanner(System.in));
                        cout("Last name (String): ");
                        String new_ln = String.valueOf(new Scanner(System.in));
                        cout("Date of bird (String): ");
                        String new_persona_date = String.valueOf(new Scanner(System.in));
                        cout("Gender (String): ");
                        String new_gender = String.valueOf(new Scanner(System.in));
                        cout("Client id (Integer): ");
                        Integer new_client_id = new Scanner(System.in).nextInt();
                        cout("Phone Number (String): ");
                        String new_phoneNumber = String.valueOf(new Scanner(System.in));
                        cout("Mail (String): ");
                        String new_mail = String.valueOf(new Scanner(System.in));

                        Client client_m = new Client(new_personal_id, new_fn, new_ln, new_persona_date, new_gender, new_client_id, new_phoneNumber, new_mail);
                        clientService.modifyById(id_m, client_m);
                        cout("************************************************************************************************************************\n\n");

                        break;
                    case 5:
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer id_d = new Scanner(System.in).nextInt();
                        clientService.removeById(id_d);
                        cout("************************************************************************************************************************\n\n");

                        break;
                    case 6:
                        break;

                }

            case 3:
                cout("************************************************************************************************************************\\n");
                cout("Choose an option: \n\n");
                cout("1 - Add a driver\n");
                cout("2 - Display o driver by id\n");
                cout("3 - Display all drivers\n");
                cout("4 - Modify a driver\n");
                cout("5 - Delete a driver\n");
                cout("6 - Back\n");
                cout("Read the number associated with the desire option: ");

                int choice_driver_1 = new Scanner(System.in).nextInt();

                cout("\n\n");
                cout("************************************************************************************************************************\n\n");

                switch (choice_driver_1) {
                    case 1:
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer personal_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        String driver_fn = String.valueOf(new Scanner(System.in));
                        cout("Last name (String): ");
                        String driver_ln = String.valueOf(new Scanner(System.in));
                        cout("Date of bird (String): ");
                        String driver_date = String.valueOf(new Scanner(System.in));
                        cout("Gender (String): ");
                        String gender_d = String.valueOf(new Scanner(System.in));
                        cout("Driver id (Integer): ");
                        Integer driver_id = new Scanner(System.in).nextInt();
                        cout("Phone Number (String): ");
                        String phoneNumber = String.valueOf(new Scanner(System.in));
                        cout("Mail (String): ");
                        String mail = String.valueOf(new Scanner(System.in));
                        cout("Driver licence date (String): ");
                        String driverLicenceDate = String.valueOf(new Scanner(System.in));


                        Set<DrivingLicenceCategories> drivingLicenceCategories = new HashSet<>();
                        cout("The number of driving licence categories: ");
                        Integer numberLicenceCategories = new Scanner(System.in).nextInt();

                        for (int j = 0; j < numberLicenceCategories; j++) {
                            String cat = String.valueOf(new Scanner(System.in));
                            switch (cat) {
                                case "AM":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.AM);
                                    break;
                                case "A1":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.A1);
                                    break;
                                case "A2":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.A2);
                                    break;
                                case "A":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.A);
                                    break;
                                case "B":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.B);
                                    break;
                                case "B1":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.B1);
                                    break;
                                case "BE":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.BE);
                                    break;
                                case "C1":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.C1);
                                    break;
                                case "C1E":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.C1E);
                                    break;
                                case "C":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.C);
                                    break;
                                case "CE":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.CE);
                                    break;
                                case "D1":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.D1);
                                    break;
                                case "D1E":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.D1E);
                                    break;
                                case "D":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.D);
                                    break;
                                case "DE":
                                    drivingLicenceCategories.add(DrivingLicenceCategories.DE);
                                    break;
                            }
                        }
                        Driver driver = new Driver(personal_id, driver_fn, driver_ln, driver_date, gender_d, driver_id, phoneNumber, mail, driverLicenceDate, drivingLicenceCategories);
                        driverService.addOnlyOne(driver);
                        cout("************************************************************************************************************************\n\n");

                    case 2:
                        cout("************************************************************************************************************************\n\n");

                        cout("Id driver:");
                        Integer Id_c = new Scanner(System.in).nextInt();
                        Optional <Driver> driver_aff = driverService.getById(Id_c);

                        if(driver_aff.isPresent()) {

                            cout("************************************************************************************************************************\n\n");
                            cout(driver_aff);
                            cout("************************************************************************************************************************\n\n");

                        }
                        else {
                            cout("Id does't exist!");
                        }
                        cout("************************************************************************************************************************\n\n");

                        break;
                    case 3:
                        List<Driver> list = driverService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Driver dr : list) {
                            cout(dr);
                        }
                        cout("************************************************************************************************************************\n\n");
                        break;
                    case 4:
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer id_m = new Scanner(System.in).nextInt();
                        cout("Read new date:");
                        cout("Personal id (Integer): ");
                        Integer new_personal_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        String new_driver_fn = String.valueOf(new Scanner(System.in));
                        cout("Last name (String): ");
                        String new_driver_ln = String.valueOf(new Scanner(System.in));
                        cout("Date of bird (String): ");
                        String new_driver_date = String.valueOf(new Scanner(System.in));
                        cout("Gender (String): ");
                        String new_gender_d = String.valueOf(new Scanner(System.in));
                        cout("Driver id (Integer): ");
                        Integer new_driver_id = new Scanner(System.in).nextInt();
                        cout("Phone Number (String): ");
                        String new_phoneNumber = String.valueOf(new Scanner(System.in));
                        cout("Mail (String): ");
                        String new_mail = String.valueOf(new Scanner(System.in));
                        cout("Driver licence date (String): ");
                        String new_driverLicenceDate = String.valueOf(new Scanner(System.in));


                        Set<DrivingLicenceCategories> new_drivingLicenceCategories = new HashSet<>();
                        cout("The number of driving licence categories: ");
                        Integer new_numberLicenceCategories = new Scanner(System.in).nextInt();

                        for (int j = 0; j < new_numberLicenceCategories; j++) {
                            String cat = String.valueOf(new Scanner(System.in));
                            switch (cat) {
                                case "AM":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.AM);
                                    break;
                                case "A1":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.A1);
                                    break;
                                case "A2":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.A2);
                                    break;
                                case "A":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.A);
                                    break;
                                case "B":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.B);
                                    break;
                                case "B1":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.B1);
                                    break;
                                case "BE":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.BE);
                                    break;
                                case "C1":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.C1);
                                    break;
                                case "C1E":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.C1E);
                                    break;
                                case "C":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.C);
                                    break;
                                case "CE":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.CE);
                                    break;
                                case "D1":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.D1);
                                    break;
                                case "D1E":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.D1E);
                                    break;
                                case "D":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.D);
                                    break;
                                case "DE":
                                    new_drivingLicenceCategories.add(DrivingLicenceCategories.DE);
                                    break;
                            }
                        }
                        Driver new_driver = new Driver(new_personal_id, new_driver_fn, new_driver_ln, new_driver_date, new_gender_d, new_driver_id, new_phoneNumber, new_mail, new_driverLicenceDate, new_drivingLicenceCategories);
                        driverService.modifyById(id_m, new_driver);
                        cout("************************************************************************************************************************\n\n");

                        break;
                    case 5:
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer id_d = new Scanner(System.in).nextInt();
                        driverService.removeById(id_d);
                        cout("************************************************************************************************************************\n\n");

                        break;
                    case 6:
                        break;

                }
            case 4:
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

                switch (choice_car_1) {
                    case 1:
                        cout("************************************************************************************************************************\n\n");

                        cout("Car id (Integer): ");
                        Integer car_id = new Scanner(System.in).nextInt();
                        cout("Driver id (Integer): ");
                        Integer driver_id = new Scanner(System.in).nextInt();
                        cout("Brand (String): ");
                        String brand = String.valueOf(new Scanner(System.in));
                        cout("Model (String): ");
                        String model = String.valueOf(new Scanner(System.in));
                        cout("IdentificationNumber (String): ");
                        String identificationNumber = String.valueOf(new Scanner(System.in));
                        cout("Color (String): ");
                        String color = String.valueOf(new Scanner(System.in));
                        Color real_color = null;
                        switch (color) {
                            case "WHITE":
                                real_color = Color.WHITE;
                                break;
                            case "BLACK" :
                                real_color = Color.BLACK;
                                break;
                            case "RED" :
                                real_color = Color.RED;
                                break;
                            case "BLUE" :
                                real_color = Color.BLUE;
                                break;
                            case "YELLOW" :
                                real_color = Color.YELLOW;
                                break;
                            case "GREEN" :
                                real_color = Color.GREEN;
                                break;
                            case "PURPLE" :
                                real_color = Color.PURPLE;
                                break;
                            case "BROWN" :
                                real_color = Color.BROWN;
                                break;
                            case "GREY" :
                                real_color = Color.GREY;
                                break;
                            case "PINK" :
                                real_color = Color.PINK;
                                break;
                        }
                        cout("Number of seats (Integer): ");
                        Integer nr = new Scanner(System.in).nextInt();
                        Car car = new Car(car_id, driver_id, brand, model, identificationNumber, real_color, nr);
                        carService.addOnlyOne(car);
                        cout("************************************************************************************************************************\n\n");
                        break;


                    case 2:
                        cout("************************************************************************************************************************\n\n");

                        cout("Id car:");
                        Integer Id_c = new Scanner(System.in).nextInt();
                        Optional <Car> car_aff = carService.getById(Id_c);

                        if(car_aff.isPresent()) {

                            cout("************************************************************************************************************************\n\n");
                            cout(car_aff);
                            cout("************************************************************************************************************************\n\n");

                        }
                        else {
                            cout("Id does't exist!");
                        }
                        cout("************************************************************************************************************************\n\n");
                        break;

                    case 3:
                        List<Car> list = carService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Car cr : list) {
                            cout(cr);
                        }
                        cout("************************************************************************************************************************\n\n");
                        break;

                    case 4:
                        cout("************************************************************************************************************************\n\n");

                        cout("Car id (Integer): ");
                        Integer id_c = new Scanner(System.in).nextInt();
                        cout("Read new date:");
                        cout("Car id (Integer): ");
                        Integer new_car_id = new Scanner(System.in).nextInt();
                        cout("Driver id (Integer): ");
                        Integer new_driver_id = new Scanner(System.in).nextInt();
                        cout("Brand (String): ");
                        String new_brand = String.valueOf(new Scanner(System.in));
                        cout("Model (String): ");
                        String new_model = String.valueOf(new Scanner(System.in));
                        cout("IdentificationNumber (String): ");
                        String new_identificationNumber = String.valueOf(new Scanner(System.in));
                        cout("Color (String): ");
                        String new_color = String.valueOf(new Scanner(System.in));
                        Color new_real_color = null;
                        switch (new_color) {
                            case "WHITE":
                                new_real_color = Color.WHITE;
                                break;
                            case "BLACK" :
                                new_real_color = Color.BLACK;
                                break;
                            case "RED" :
                                new_real_color = Color.RED;
                                break;
                            case "BLUE" :
                                new_real_color = Color.BLUE;
                                break;
                            case "YELLOW" :
                                new_real_color = Color.YELLOW;
                                break;
                            case "GREEN" :
                                new_real_color = Color.GREEN;
                                break;
                            case "PURPLE" :
                                new_real_color = Color.PURPLE;
                                break;
                            case "BROWN" :
                                new_real_color = Color.BROWN;
                                break;
                            case "GREY" :
                                new_real_color = Color.GREY;
                                break;
                            case "PINK" :
                                new_real_color = Color.PINK;
                                break;
                        }
                        cout("Number of seats (Integer): ");
                        Integer new_nr = new Scanner(System.in).nextInt();
                        Car new_car = new Car(new_car_id, new_driver_id, new_brand, new_model, new_identificationNumber, new_real_color, new_nr);
                        carService.modifyById(id_c, new_car);
                        cout("************************************************************************************************************************\n\n");
                        break;
                    case 5:
                        cout("************************************************************************************************************************\n\n");

                        cout("Car id (Integer): ");
                        Integer id_ca = new Scanner(System.in).nextInt();
                        carService.removeById(id_ca);
                        cout("************************************************************************************************************************\n\n");

                        break;
                    case 6:
                        break;
                }
            case 5:
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

                switch (choice_location_1) {
                    case 1:
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer id_m = new Scanner(System.in).nextInt();
                        cout("Read new date:");
                        cout("Personal id (Integer): ");
                        Integer new_personal_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        String new_driver_fn = String.valueOf(new Scanner(System.in));
                        cout("Last name (String): ");
                        String new_driver_ln = String.valueOf(new Scanner(System.in));
                        cout("Date of bird (String): ");
                        String new_driver_date = String.valueOf(new Scanner(System.in));
                        cout("Gender (String): ");
                        String new_gender_d = String.valueOf(new Scanner(System.in));
                        cout("Driver id (Integer): ");
                        Integer new_driver_id = new Scanner(System.in).nextInt();
                        cout("Phone Number (String): ");
                        String new_phoneNumber = String.valueOf(new Scanner(System.in));
                        cout("Mail (String): ");
                        String new_mail = String.valueOf(new Scanner(System.in));
                        cout("Driver licence date (String): ");
                        String new_driverLicenceDate = String.valueOf(new Scanner(System.in));
                }





        }
    }
}
