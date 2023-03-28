package application;

import model.Client;
import model.*;
import model.enums.DriverLicence;
import service.*;
import service.impl.*;

import model.enums.Color;
import model.Car;
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

         */
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
    }
}
