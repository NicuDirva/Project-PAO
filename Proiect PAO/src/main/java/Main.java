import Repository.CarRepository;
import Repository.impl.CarRepositoyImpl;
import model.Car;
import model.enums.Color;
import service.CarService;
import service.impl.CarServiceImpl;
import application.Menu;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu menu = Menu.getInstance();

            menu.intro();

            if ("exit".equals(scanner.next())) {
                break;
            }

        }

    }

}