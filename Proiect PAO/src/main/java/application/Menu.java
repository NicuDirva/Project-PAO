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
    private final PersonService personService = new PersonServiceImpl();
    private final CompanyService companyService = new CompanyServiceImpl();
    private final DriverService driverService = new DriverServiceImpl();
    private final LocationService locationService = new LocationServiceImpl();
    private final OrderReviewService orderReviewService = new OrderReviewImpl();
    private final OrderService orderService = new OrderServiceImpl();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    private Menu() {}

    void cout(Object line) {
        System.out.println(line);
    }

    public void intro() {
        boolean glb = true;
        while(glb) {
            cout("************************************************************************************************************************\\n");
            cout("Choose an option: \n\n");
            cout("1 - Company operation\n");
            cout("2 - Client operation\n");
            cout("3 - Driver operation\n");
            cout("4 - Car operation\n");
            cout("5 - Location operation\n");
            cout("6 - Order operation\n");
            cout("7 - OrderReview operation\n");
            cout("8 - Person operation\n");
            cout("9 - Exit\n");
            cout("Read the number associated with the desire option: ");

            int choice = new Scanner(System.in).nextInt();

            cout("\n\n");
            cout("************************************************************************************************************************\n\n");

            boolean bool_c = true, bool_client = true, bool_driver = true, bool_car = true, bool_location = true, bool_order = true, bool_orderreview = true, bool_person=true;
            if(choice == 1) {
                while (bool_c) {
                    cout("************************************************************************************************************************\\n");
                    cout("Choose an option: \n\n");
                    cout("1 - Add a company\n");
                    cout("2 - Display o company by id\n");
                    cout("3 - Display all companies\n");
                    cout("4 - Modify a company\n");
                    cout("5 - Delete a company\n");
                    cout("6 - Add new driver in the company\n");
                    cout("7 - Change the number of employees in the company\n");
                    cout("8 - Change company name\n");
                    cout("9 - Sort the drivers in the company\n");
                    cout("10 - Back\n");
                    cout("Read the number associated with the desire option: ");

                    int choice_company_1 = new Scanner(System.in).nextInt();

                    cout("\n\n");
                    cout("************************************************************************************************************************\n\n");

                    if (choice_company_1 == 1) {
                        cout("************************************************************************************************************************\\n");
                        cout("Company id (Integer): ");
                        Integer Id = new Scanner(System.in).nextInt();
                        cout("Company name (String): ");
                        Scanner str1 = new Scanner(System.in);
                        String name = str1.nextLine();
                        cout("The date of establishment  of the company (String): ");
                        Scanner str2 = new Scanner(System.in);
                        String date = str2.nextLine();

                        Person owner;

                        cout("Information about the owner of the company");
                        cout("Personal id (Integer): ");
                        Integer owner_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        Scanner str3 = new Scanner(System.in);
                        String owner_fn = str3.nextLine();
                        cout("Last name (String): ");
                        Scanner str4 = new Scanner(System.in);
                        String owner_ln = str4.nextLine();
                        cout("Date of bird (String): ");
                        Scanner str5 = new Scanner(System.in);
                        String owner_date = str5.nextLine();
                        cout("Gender (String): ");
                        Scanner str6 = new Scanner(System.in);
                        String gender = str6.nextLine();
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
                            Scanner str7 = new Scanner(System.in);
                            String driver_fn = str7.nextLine();
                            cout("Last name (String): ");
                            Scanner str8 = new Scanner(System.in);
                            String driver_ln = str8.nextLine();
                            cout("Date of bird (String): ");
                            Scanner str9 = new Scanner(System.in);
                            String driver_date = str9.nextLine();
                            cout("Gender (String): ");
                            Scanner str10 = new Scanner(System.in);
                            String gender_d = str10.nextLine();
                            cout("Driver id (Integer): ");
                            Integer driver_id = new Scanner(System.in).nextInt();
                            cout("Phone Number (String): ");
                            Scanner str11 = new Scanner(System.in);
                            String phoneNumber = str11.nextLine();
                            cout("Mail (String): ");
                            Scanner str12 = new Scanner(System.in);
                            String mail = str12.nextLine();
                            cout("Driver licence date (String): ");
                            Scanner str13 = new Scanner(System.in);
                            String driverLicenceDate = str13.nextLine();

                            driverList = new ArrayList<>();

                            Set<DrivingLicenceCategories> drivingLicenceCategories = new HashSet<>();
                            cout("The number of driving licence categories: ");
                            Integer numberLicenceCategories = new Scanner(System.in).nextInt();

                            for (int j = 0; j < numberLicenceCategories; j++) {
                                Scanner str14 = new Scanner(System.in);
                                String cat = str14.nextLine();
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
                    }

                    if (choice_company_1 == 2) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Id company:");
                        Integer Id_c = new Scanner(System.in).nextInt();
                        Optional<Company> company_aff = companyService.getById(Id_c);

                        if (company_aff.isPresent()) {

                            cout("************************************************************************************************************************\n\n");
                            cout(company_aff);
                            cout("************************************************************************************************************************\n\n");

                        } else {
                            cout("Id does't exist!");
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_company_1 == 3) {
                        List<Company> list = companyService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Company cp : list) {
                            cout(cp);
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_company_1 == 4) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer id_m = new Scanner(System.in).nextInt();
                        cout("Read new date:");
                        cout("Company id (Integer): ");
                        Integer new_Id = new Scanner(System.in).nextInt();
                        cout("Company name (String): ");
                        Scanner str15 = new Scanner(System.in);
                        String new_name = str15.nextLine();
                        cout("The date of establishment  of the company (String): ");
                        Scanner str16 = new Scanner(System.in);
                        String new_date = str16.nextLine();

                        Person new_owner;

                        cout("Information about the owner of the company");
                        cout("Personal id (Integer): ");
                        Integer new_owner_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        Scanner str17 = new Scanner(System.in);
                        String new_owner_fn = str17.nextLine();
                        cout("Last name (String): ");
                        Scanner str18 = new Scanner(System.in);
                        String new_owner_ln = str18.nextLine();
                        cout("Date of bird (String): ");
                        Scanner str19 = new Scanner(System.in);
                        String new_owner_date = str19.nextLine();
                        cout("Gender (String): ");
                        Scanner str20 = new Scanner(System.in);
                        String new_gender = str20.nextLine();
                        new_owner = new Person(new_owner_id, new_owner_fn, new_owner_ln, new_owner_date, new_gender);


                        cout("The number of employees in the company(String): ");
                        Integer new_employeesnumber = new Scanner(System.in).nextInt();

                        List<Driver> new_driverList = null;

                        cout("The number of drivers in the company: ");
                        Integer new_driversnumber = new Scanner(System.in).nextInt();
                        for (int i = 0; i < new_driversnumber; i++) {
                            cout("Personal id (Integer): ");
                            Integer personal_id = new Scanner(System.in).nextInt();
                            cout("First name (String): ");
                            Scanner str21 = new Scanner(System.in);
                            String driver_fn = str21.nextLine();
                            cout("Last name (String): ");
                            Scanner str22 = new Scanner(System.in);
                            String driver_ln = str22.nextLine();
                            cout("Date of bird (String): ");
                            Scanner str23 = new Scanner(System.in);
                            String driver_date = str23.nextLine();
                            cout("Gender (String): ");
                            Scanner str24 = new Scanner(System.in);
                            String gender_d = str24.nextLine();
                            cout("Driver id (Integer): ");
                            Integer driver_id = new Scanner(System.in).nextInt();
                            cout("Phone Number (String): ");
                            Scanner str25 = new Scanner(System.in);
                            String phoneNumber = str25.nextLine();
                            cout("Mail (String): ");
                            Scanner str26 = new Scanner(System.in);
                            String mail = str26.nextLine();
                            cout("Driver licence date (String): ");
                            Scanner str27 = new Scanner(System.in);
                            String driverLicenceDate = str27.nextLine();


                            Set<DrivingLicenceCategories> drivingLicenceCategories = new HashSet<>();
                            cout("The number of driving licence categories: ");
                            Integer numberLicenceCategories = new Scanner(System.in).nextInt();

                            for (int j = 0; j < numberLicenceCategories; j++) {
                                Scanner str28 = new Scanner(System.in);
                                String cat = str28.nextLine();
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
                    }

                    if (choice_company_1 == 5) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Company id (Integer): ");
                        Integer id_c = new Scanner(System.in).nextInt();
                        companyService.removeById(id_c);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_company_1 == 6) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Company id (Integer): ");
                        Integer com_id = new Scanner(System.in).nextInt();
                        cout("Read driver date:");
                        cout("Personal id (Integer): ");
                        Integer personal_id_c = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        Scanner str29 = new Scanner(System.in);
                        String driver_fn_c = str29.nextLine();
                        cout("Last name (String): ");
                        Scanner str30 = new Scanner(System.in);
                        String driver_ln_c = str30.nextLine();
                        cout("Date of bird (String): ");
                        Scanner str31 = new Scanner(System.in);
                        String driver_date_c = str31.nextLine();
                        cout("Gender (String): ");
                        Scanner str32 = new Scanner(System.in);
                        String gender_d_c = str32.nextLine();
                        cout("Driver id (Integer): ");
                        Integer driver_id_c = new Scanner(System.in).nextInt();
                        cout("Phone Number (String): ");
                        Scanner str33 = new Scanner(System.in);
                        String phoneNumber_c = str33.nextLine();
                        cout("Mail (String): ");
                        Scanner str34 = new Scanner(System.in);
                        String mail_c = str34.nextLine();
                        cout("Driver licence date (String): ");
                        Scanner str35 = new Scanner(System.in);
                        String driverLicenceDate_c = str35.nextLine();


                        Set<DrivingLicenceCategories> drivingLicenceCategories_c = new HashSet<>();
                        cout("The number of driving licence categories: ");
                        Integer numberLicenceCategories_c = new Scanner(System.in).nextInt();

                        for (int j = 0; j < numberLicenceCategories_c; j++) {
                            Scanner str36 = new Scanner(System.in);
                            String cat_c = str36.nextLine();
                            switch (cat_c) {
                                case "AM":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.AM);
                                    break;
                                case "A1":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.A1);
                                    break;
                                case "A2":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.A2);
                                    break;
                                case "A":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.A);
                                    break;
                                case "B":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.B);
                                    break;
                                case "B1":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.B1);
                                    break;
                                case "BE":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.BE);
                                    break;
                                case "C1":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.C1);
                                    break;
                                case "C1E":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.C1E);
                                    break;
                                case "C":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.C);
                                    break;
                                case "CE":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.CE);
                                    break;
                                case "D1":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.D1);
                                    break;
                                case "D1E":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.D1E);
                                    break;
                                case "D":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.D);
                                    break;
                                case "DE":
                                    drivingLicenceCategories_c.add(DrivingLicenceCategories.DE);
                                    break;
                            }
                        }
                        Driver driver_c = new Driver(personal_id_c, driver_fn_c, driver_ln_c, driver_date_c, gender_d_c, driver_id_c, phoneNumber_c, mail_c, driverLicenceDate_c, drivingLicenceCategories_c);
                        companyService.addNewDriver(com_id, driver_c);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_company_1 == 7) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Company id (Integer): ");
                        Integer com_nr = new Scanner(System.in).nextInt();
                        cout("Number of employees");
                        Integer new_nr = new Scanner(System.in).nextInt();
                        companyService.changeEmployeesNumber(com_nr, new_nr);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_company_1 == 8) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Company id (Integer): ");
                        Integer com_n = new Scanner(System.in).nextInt();
                        cout("New name");
                        Scanner str37 = new Scanner(System.in);
                        String new_n = str37.nextLine();
                        companyService.changeCompanyName(com_n, new_n);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_company_1 == 9) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Company id (Integer): ");
                        Integer com_s = new Scanner(System.in).nextInt();
                        companyService.sortDrivers(com_s);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if (choice_company_1 == 10) {
                        bool_c = false;
                    }

                }
            }

            if(choice == 2){
                while(bool_client){
                    cout("************************************************************************************************************************\\n");
                    cout("Choose an option: \n\n");
                    cout("1 - Add a client\n");
                    cout("2 - Display o client by id\n");
                    cout("3 - Display all clients\n");
                    cout("4 - Modify a client\n");
                    cout("5 - Delete a client\n");
                    cout("6 - Change phone number of a client\n");
                    cout("7 - Change mail of a client\n");
                    cout("8 - Back\n");
                    cout("Read the number associated with the desire option: ");

                    int choice_client_1 = new Scanner(System.in).nextInt();

                    cout("\n\n");
                    cout("************************************************************************************************************************\n\n");


                    if(choice_client_1 == 1) {
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
                    if(choice_client_1 == 2) {
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
                    if(choice_client_1 == 3) {
                        List<Client> list = clientService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Client cl : list) {
                            cout(cl);
                        }
                        cout("************************************************************************************************************************\n\n");
                    }
                    if(choice_client_1 == 4) {
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

                    if(choice_client_1 == 6) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Client id (Integer): ");
                        Integer client_ph = new Scanner(System.in).nextInt();
                        cout("New phone number (String):");
                        Scanner str49 = new Scanner(System.in);
                        String new_ph = str49.nextLine();
                        clientService.changePhoneNumber(client_ph, new_ph);
                        cout("************************************************************************************************************************\n\n");
                    }
                    if(choice_client_1 == 7) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Client id (Integer): ");
                        Integer id_nm = new Scanner(System.in).nextInt();
                        cout("New mail (String):");
                        Scanner str50 = new Scanner(System.in);
                        String client_nm = str50.nextLine();
                        clientService.changeMail(id_nm, client_nm);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_client_1 == 8) {
                        bool_client=false;
                    }
                }
            }


            if(choice == 3){
                while(bool_driver) {
                    cout("************************************************************************************************************************\\n");
                    cout("Choose an option: \n\n");
                    cout("1 - Add a driver\n");
                    cout("2 - Display o driver by id\n");
                    cout("3 - Display all drivers\n");
                    cout("4 - Modify a driver\n");
                    cout("5 - Delete a driver\n");
                    cout("6 - Change phone number of a driver\n");
                    cout("7 - Change mail of a driver\n");
                    cout("8 - Add new licence driver categories\n");
                    cout("9 - Back\n");
                    cout("Read the number associated with the desire option: ");

                    int choice_driver_1 = new Scanner(System.in).nextInt();

                    cout("\n\n");
                    cout("************************************************************************************************************************\n\n");

                    if(choice_driver_1 == 1) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer personal_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        Scanner str51 = new Scanner(System.in);
                        String driver_fn = str51.nextLine();
                        cout("Last name (String): ");
                        Scanner str52 = new Scanner(System.in);
                        String driver_ln = str52.nextLine();
                        cout("Date of bird (String): ");
                        Scanner str53 = new Scanner(System.in);
                        String driver_date = str53.nextLine();
                        cout("Gender (String): ");
                        Scanner str54 = new Scanner(System.in);
                        String gender_d = str54.nextLine();
                        cout("Driver id (Integer): ");
                        Integer driver_id = new Scanner(System.in).nextInt();
                        cout("Phone Number (String): ");
                        Scanner str55 = new Scanner(System.in);
                        String phoneNumber = str55.nextLine();
                        cout("Mail (String): ");
                        Scanner str56 = new Scanner(System.in);
                        String mail = str56.nextLine();
                        cout("Driver licence date (String): ");
                        Scanner str57 = new Scanner(System.in);
                        String driverLicenceDate = str57.nextLine();


                        Set<DrivingLicenceCategories> drivingLicenceCategories = new HashSet<>();
                        cout("The number of driving licence categories: ");
                        Integer numberLicenceCategories = new Scanner(System.in).nextInt();

                        for (int j = 0; j < numberLicenceCategories; j++) {
                            Scanner str58 = new Scanner(System.in);
                            String cat = str58.nextLine();
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
                    }
                    if(choice_driver_1 == 2) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Id driver:");
                        Integer Id_c = new Scanner(System.in).nextInt();
                        Optional<Driver> driver_aff = driverService.getById(Id_c);

                        if (driver_aff.isPresent()) {

                            cout("************************************************************************************************************************\n\n");
                            cout(driver_aff);
                            cout("************************************************************************************************************************\n\n");

                        } else {
                            cout("Id does't exist!");
                        }
                        cout("************************************************************************************************************************\n\n");

                    }
                    if(choice_driver_1 == 3) {
                        List<Driver> list = driverService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Driver dr : list) {
                            cout(dr);
                        }
                        cout("************************************************************************************************************************\n\n");
                    }
                    if(choice_driver_1 == 4) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer id_m = new Scanner(System.in).nextInt();
                        cout("Read new date:");
                        cout("Personal id (Integer): ");
                        Integer new_personal_id = new Scanner(System.in).nextInt();
                        cout("First name (String): ");
                        Scanner str59 = new Scanner(System.in);
                        String new_driver_fn = str59.nextLine();
                        cout("Last name (String): ");
                        Scanner str60 = new Scanner(System.in);
                        String new_driver_ln = str60.nextLine();
                        cout("Date of bird (String): ");
                        Scanner str61 = new Scanner(System.in);
                        String new_driver_date = str61.nextLine();
                        cout("Gender (String): ");
                        Scanner str62 = new Scanner(System.in);
                        String new_gender_d = str62.nextLine();
                        cout("Driver id (Integer): ");
                        Integer new_driver_id = new Scanner(System.in).nextInt();
                        cout("Phone Number (String): ");
                        Scanner str63 = new Scanner(System.in);
                        String new_phoneNumber = str63.nextLine();
                        cout("Mail (String): ");
                        Scanner str64 = new Scanner(System.in);
                        String new_mail = str64.nextLine();
                        cout("Driver licence date (String): ");
                        Scanner str65 = new Scanner(System.in);
                        String new_driverLicenceDate = str65.nextLine();


                        Set<DrivingLicenceCategories> new_drivingLicenceCategories = new HashSet<>();
                        cout("The number of driving licence categories: ");
                        Integer new_numberLicenceCategories = new Scanner(System.in).nextInt();

                        for (int j = 0; j < new_numberLicenceCategories; j++) {
                            Scanner str66 = new Scanner(System.in);
                            String cat = str66.nextLine();
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

                    }
                    if(choice_driver_1 == 5) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Personal id (Integer): ");
                        Integer id_d = new Scanner(System.in).nextInt();
                        driverService.removeById(id_d);
                        cout("************************************************************************************************************************\n\n");

                    }

                    if(choice_driver_1 == 6) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Driver id (Integer): ");
                        Integer driver_ph = new Scanner(System.in).nextInt();
                        cout("New phone number (String):");
                        Scanner str67 = new Scanner(System.in);
                        String new_ph_d = str67.nextLine();
                        driverService.changePhoneNumber(driver_ph, new_ph_d);
                        cout("************************************************************************************************************************\n\n");
                    }
                    if(choice_driver_1 == 7) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Driver id (Integer): ");
                        Integer id_nm_d = new Scanner(System.in).nextInt();
                        cout("New mail (String):");
                        Scanner str68 = new Scanner(System.in);
                        String client_nm_d = str68.nextLine();
                        driverService.changeMail(id_nm_d, client_nm_d);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_driver_1 == 8) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Driver id (Integer): ");
                        Integer id_nl_d = new Scanner(System.in).nextInt();
                        Set<DrivingLicenceCategories> drl = new HashSet<>();

                        cout("Name of licence categories");
                        Scanner str69 = new Scanner(System.in);
                        String new_l = str69.nextLine();
                        switch (new_l) {
                            case "AM":
                                drl.add(DrivingLicenceCategories.AM);
                                break;
                            case "A1":
                                drl.add(DrivingLicenceCategories.A1);
                                break;
                            case "A2":
                                drl.add(DrivingLicenceCategories.A2);
                                break;
                            case "A":
                                drl.add(DrivingLicenceCategories.A);
                                break;
                            case "B":
                                drl.add(DrivingLicenceCategories.B);
                                break;
                            case "B1":
                                drl.add(DrivingLicenceCategories.B1);
                                break;
                            case "BE":
                                drl.add(DrivingLicenceCategories.BE);
                                break;
                            case "C1":
                                drl.add(DrivingLicenceCategories.C1);
                                break;
                            case "C1E":
                                drl.add(DrivingLicenceCategories.C1E);
                                break;
                            case "C":
                                drl.add(DrivingLicenceCategories.C);
                                break;
                            case "CE":
                                drl.add(DrivingLicenceCategories.CE);
                                break;
                            case "D1":
                                drl.add(DrivingLicenceCategories.D1);
                                break;
                            case "D1E":
                                drl.add(DrivingLicenceCategories.D1E);
                                break;
                            case "D":
                                drl.add(DrivingLicenceCategories.D);
                                break;
                            case "DE":
                                drl.add(DrivingLicenceCategories.DE);
                                break;
                        }

                        for (Driver driverr : driverService.getAll()) {
                            if (driverr.getDriverId() == id_nl_d) {
                                driverService.removeById(id_nl_d);
                                Driver new_dr = new Driver(driverr.getPersonId(), driverr.getFirstName(), driverr.getLastName(), driverr.getDateOfBird(), driverr.getGender(), driverr.getDriverId(), driverr.getPhoneNumber(), driverr.getMail(), driverr.getDriverLicenceDate(), drl);
                                driverService.addOnlyOne(new_dr);
                            }
                        }

                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_driver_1 == 9) {
                        bool_driver = false;
                    }

                }
            }
            if(choice == 4) {
                while (bool_car) {
                    cout("************************************************************************************************************************\\n");
                    cout("Choose an option: \n\n");
                    cout("1 - Add a car\n");
                    cout("2 - Display o car by id\n");
                    cout("3 - Display all cars\n");
                    cout("4 - Modify a car\n");
                    cout("5 - Delete a car\n");
                    cout("6 - Change color\n");
                    cout("7 - Back\n");
                    cout("Read the number associated with the desire option: ");

                    int choice_car_1 = new Scanner(System.in).nextInt();

                    cout("\n\n");
                    cout("************************************************************************************************************************\n\n");

                    if(choice_car_1 == 1) {
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
                        Color real_color = null;
                        switch (color) {
                            case "WHITE":
                                real_color = Color.WHITE;
                                break;
                            case "BLACK":
                                real_color = Color.BLACK;
                                break;
                            case "RED":
                                real_color = Color.RED;
                                break;
                            case "BLUE":
                                real_color = Color.BLUE;
                                break;
                            case "YELLOW":
                                real_color = Color.YELLOW;
                                break;
                            case "GREEN":
                                real_color = Color.GREEN;
                                break;
                            case "PURPLE":
                                real_color = Color.PURPLE;
                                break;
                            case "BROWN":
                                real_color = Color.BROWN;
                                break;
                            case "GREY":
                                real_color = Color.GREY;
                                break;
                            case "PINK":
                                real_color = Color.PINK;
                                break;
                        }
                        cout("Number of seats (Integer): ");
                        Integer nr = new Scanner(System.in).nextInt();
                        Car car = new Car(car_id, driver_id, brand, model, identificationNumber, real_color, nr);
                        carService.addOnlyOne(car);
                        cout("************************************************************************************************************************\n\n");
                    }


                    if(choice_car_1 == 2) {
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

                    if(choice_car_1 == 3) {
                        List<Car> list = carService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Car cr : list) {
                            cout(cr);
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_car_1 == 4) {
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
                        Color new_real_color = null;
                        switch (new_color) {
                            case "WHITE":
                                new_real_color = Color.WHITE;
                                break;
                            case "BLACK":
                                new_real_color = Color.BLACK;
                                break;
                            case "RED":
                                new_real_color = Color.RED;
                                break;
                            case "BLUE":
                                new_real_color = Color.BLUE;
                                break;
                            case "YELLOW":
                                new_real_color = Color.YELLOW;
                                break;
                            case "GREEN":
                                new_real_color = Color.GREEN;
                                break;
                            case "PURPLE":
                                new_real_color = Color.PURPLE;
                                break;
                            case "BROWN":
                                new_real_color = Color.BROWN;
                                break;
                            case "GREY":
                                new_real_color = Color.GREY;
                                break;
                            case "PINK":
                                new_real_color = Color.PINK;
                                break;
                        }
                        cout("Number of seats (Integer): ");
                        Integer new_nr = new Scanner(System.in).nextInt();
                        Car new_car = new Car(new_car_id, new_driver_id, new_brand, new_model, new_identificationNumber, new_real_color, new_nr);
                        carService.modifyById(id_c, new_car);
                        cout("************************************************************************************************************************\n\n");
                    }
                    if(choice_car_1 == 5) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Car id (Integer): ");
                        Integer id_ca = new Scanner(System.in).nextInt();
                        carService.removeById(id_ca);
                        cout("************************************************************************************************************************\n\n");

                    }

                    if(choice_car_1 == 6) {
                        cout("Car id (Integer): ");
                        Integer id_car = new Scanner(System.in).nextInt();
                        cout("New color (String): ");
                        Scanner str78 = new Scanner(System.in);
                        String color1 = str78.nextLine();
                        Color real_color1 = null;
                        switch (color1) {
                            case "WHITE":
                                real_color1 = Color.WHITE;
                                break;
                            case "BLACK":
                                real_color1 = Color.BLACK;
                                break;
                            case "RED":
                                real_color1 = Color.RED;
                                break;
                            case "BLUE":
                                real_color1 = Color.BLUE;
                                break;
                            case "YELLOW":
                                real_color1 = Color.YELLOW;
                                break;
                            case "GREEN":
                                real_color1 = Color.GREEN;
                                break;
                            case "PURPLE":
                                real_color1 = Color.PURPLE;
                                break;
                            case "BROWN":
                                real_color1 = Color.BROWN;
                                break;
                            case "GREY":
                                real_color1 = Color.GREY;
                                break;
                            case "PINK":
                                real_color1 = Color.PINK;
                                break;
                        }
                        carService.changeColor(id_car, real_color1);
                        cout("************************************************************************************************************************\\n");
                    }

                    if(choice_car_1 == 7) {
                        bool_car = false;
                    }
                }
            }

            if(choice == 5) {
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


                    if(choice_location_1 == 1) {
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

                    if(choice_location_1 == 2) {
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

                    if(choice_location_1 == 3) {
                        List<Location> list = locationService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Location locc : list) {
                            cout(locc);
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_location_1 == 4) {
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

                    if(choice_location_1 == 5) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Location id (Integer): ");
                        Integer id_lll = new Scanner(System.in).nextInt();
                        locationService.removeById(id_lll);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_location_1 == 6) {
                        bool_location = false;
                    }
                }
            }

            if(choice == 6) {
                while (bool_order) {
                    cout("************************************************************************************************************************\\n");
                    cout("Choose an option: \n\n");
                    cout("1 - Add a order\n");
                    cout("2 - Display o order by id\n");
                    cout("3 - Display all orders\n");
                    cout("4 - Modify a order\n");
                    cout("5 - Delete a order\n");
                    cout("6 - Canceled order\n");
                    cout("7 - Change order location\n");
                    cout("8 - Add order delay\n");
                    cout("9 - Back\n");
                    cout("Read the number associated with the desire option: ");

                    int choice_order_1 = new Scanner(System.in).nextInt();

                    cout("\n\n");
                    cout("************************************************************************************************************************\n\n");

                    if(choice_order_1 == 1) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Order id (Integer): ");
                        Integer order_id = new Scanner(System.in).nextInt();
                        cout("Client id (Integer): ");
                        Integer client_id_o = new Scanner(System.in).nextInt();
                        cout("Driver id (Integer): ");
                        Integer driver_id_o = new Scanner(System.in).nextInt();
                        cout("Location id (Integer): ");
                        Integer location_id_o = new Scanner(System.in).nextInt();
                        cout("Order price(Double): ");
                        Double price = new Scanner(System.in).nextDouble();
                        cout("Driver tip price(Double): ");
                        Double driver_t = new Scanner(System.in).nextDouble();
                        cout("Ordering time (String): ");
                        Scanner str83 = new Scanner(System.in);
                        String o_time = str83.nextLine();
                        cout("Receiving time (String): ");
                        Scanner str84 = new Scanner(System.in);
                        String r_time = str84.nextLine();

                        Order order = new Order(order_id, client_id_o, driver_id_o, location_id_o, price, driver_t, o_time, r_time);
                        orderService.addOnlyOne(order);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_order_1 == 2) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Order id review:");
                        Integer Id_ord = new Scanner(System.in).nextInt();
                        Optional<Order> ord_aff = orderService.getById(Id_ord);

                        if (ord_aff.isPresent()) {

                            cout("************************************************************************************************************************\n\n");
                            cout(ord_aff);
                            cout("************************************************************************************************************************\n\n");

                        } else {
                            cout("Id does't exist!");
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_order_1 == 3) {
                        List<Order> list = orderService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Order ord : list) {
                            cout(ord);
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_order_1 == 4) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Order id (Integer): ");
                        Integer new_id_ord = new Scanner(System.in).nextInt();
                        cout("Read new date:");
                        cout("Order id (Integer): ");
                        Integer new_order_id = new Scanner(System.in).nextInt();
                        cout("Client id (Integer): ");
                        Integer new_client_id_o = new Scanner(System.in).nextInt();
                        cout("Driver id (Integer): ");
                        Integer new_driver_id_o = new Scanner(System.in).nextInt();
                        cout("Location id (Integer): ");
                        Integer new_location_id_o = new Scanner(System.in).nextInt();
                        cout("Order price(Double): ");
                        Double new_price = new Scanner(System.in).nextDouble();
                        cout("Driver tip price(Double): ");
                        Double new_driver_t = new Scanner(System.in).nextDouble();
                        cout("Ordering time (String): ");
                        Scanner str85 = new Scanner(System.in);
                        String new_o_time = str85.nextLine();
                        cout("Receiving time (String): ");
                        Scanner str86 = new Scanner(System.in);
                        String new_r_time = str86.nextLine();

                        Order new_order = new Order(new_order_id, new_client_id_o, new_driver_id_o, new_location_id_o, new_price, new_driver_t, new_o_time, new_r_time);
                        orderService.modifyById(new_id_ord, new_order);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_order_1 == 5) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Order id (Integer): ");
                        Integer id_ordd = new Scanner(System.in).nextInt();
                        orderService.removeById(id_ordd);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_order_1 == 6) {
                        cout("Order id (Integer): ");
                        Integer order_id_c = new Scanner(System.in).nextInt();
                        orderService.orderCancelated(order_id_c);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_order_1 == 7) {
                        cout("Order id (Integer): ");
                        Integer order_id_l = new Scanner(System.in).nextInt();

                        cout("Location id (Integer): ");
                        Integer id_l = new Scanner(System.in).nextInt();
                        cout("City (String): ");
                        Scanner str87 = new Scanner(System.in);
                        String city = str87.nextLine();
                        cout("Street (String): ");
                        Scanner str88 = new Scanner(System.in);
                        String street = str88.nextLine();
                        cout("Number (Integer): ");
                        Integer number = new Scanner(System.in).nextInt();
                        Location loc_o = new Location(id_l, city, street, number);

                        orderService.changeOrderLocation(order_id_l, loc_o);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_order_1 == 8) {
                        cout("Order id (Integer): ");
                        Integer order_id_d = new Scanner(System.in).nextInt();
                        cout("New order receiving (String): ");
                        Scanner str89 = new Scanner(System.in);
                        String new_r = str89.nextLine();

                        for (Order ord : orderService.getAll()) {
                            if (ord.getOrderId() == order_id_d) {
                                Order new_ord = new Order(ord.getOrderId(), ord.getClientId(), ord.getDriverId(), ord.getLocationId(), ord.getPrice(), ord.getDriverTip(), ord.getOrderingTime(), new_r);
                                orderService.modifyById(order_id_d, new_ord);
                                break;
                            }
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_order_1 == 9) {
                        bool_order = false;
                    }

                }
            }

            if(choice == 7) {
                while (bool_orderreview) {
                    cout("************************************************************************************************************************\\n");
                    cout("Choose an option: \n\n");
                    cout("1 - Add a order review\n");
                    cout("2 - Display o order review by id\n");
                    cout("3 - Display all orders review\n");
                    cout("4 - Modify a order review\n");
                    cout("5 - Delete a order review\n");
                    cout("6 - Back\n");
                    cout("Read the number associated with the desire option: ");

                    int choice_or_1 = new Scanner(System.in).nextInt();

                    cout("\n\n");
                    cout("************************************************************************************************************************\n\n");

                    if(choice_or_1 == 1) {
                        cout("************************************************************************************************************************\n\n");

                        cout("OrderReview id (Integer): ");
                        Integer id_r = new Scanner(System.in).nextInt();
                        cout("Order id (Integer): ");
                        Integer id_ord = new Scanner(System.in).nextInt();
                        cout("Number of star id (Integer): ");
                        Integer nr_stars = new Scanner(System.in).nextInt();
                        cout("Complaints (String): ");
                        Scanner str90 = new Scanner(System.in);
                        String complaints = str90.nextLine();

                        OrderReview ord_rev = new OrderReview(id_r, id_ord, nr_stars, complaints);
                        orderReviewService.addOnlyOne(ord_rev);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_or_1 == 2) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Id order review:");
                        Integer Id_or = new Scanner(System.in).nextInt();
                        Optional<OrderReview> or_aff = orderReviewService.getById(Id_or);

                        if (or_aff.isPresent()) {

                            cout("************************************************************************************************************************\n\n");
                            cout(or_aff);
                            cout("************************************************************************************************************************\n\n");

                        } else {
                            cout("Id does't exist!");
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_or_1 == 3) {
                        List<OrderReview> list = orderReviewService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (OrderReview or : list) {
                            cout(or);
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_or_1 == 4) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Order review id (Integer): ");
                        Integer new_id_or = new Scanner(System.in).nextInt();
                        cout("Read new date:");
                        cout("OrderReview id (Integer): ");
                        Integer new_id_r = new Scanner(System.in).nextInt();
                        cout("Order id (Integer): ");
                        Integer new_id_ord = new Scanner(System.in).nextInt();
                        cout("Number of star id (Integer): ");
                        Integer new_nr_stars = new Scanner(System.in).nextInt();
                        cout("Complaints (String): ");
                        Scanner str91 = new Scanner(System.in);
                        String new_complaints = str91.nextLine();

                        OrderReview new_or = new OrderReview(new_id_r, new_id_ord, new_nr_stars, new_complaints);
                        orderReviewService.modifyById(new_id_or, new_or);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_or_1 == 5) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Order review id (Integer): ");
                        Integer id_orr = new Scanner(System.in).nextInt();
                        orderReviewService.removeById(id_orr);
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_or_1 == 6) {
                        bool_orderreview = false;
                    }

                }
            }

            if(choice == 8) {
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

                    if(choice_person_1 == 1) {
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

                    if(choice_person_1 == 2) {
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

                    if(choice_person_1 == 3) {
                        List<Person> list = personService.getAll();

                        cout("************************************************************************************************************************\n\n");

                        for (Person per : list) {
                            cout(per);
                        }
                        cout("************************************************************************************************************************\n\n");
                    }

                    if(choice_person_1 == 4) {
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

                    if(choice_person_1 == 5) {
                        cout("************************************************************************************************************************\n\n");

                        cout("Person id (Integer): ");
                        Integer id_pp = new Scanner(System.in).nextInt();
                        personService.removeById(id_pp);
                        cout("************************************************************************************************************************\n\n");

                    }
                    if(choice_person_1 == 6) {
                        bool_person = false;
                    }


                }
            }

            if(choice == 9) {
                glb = false;
            }
        }

    }
}
