package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.addUser(new User("User1", "Lastname1", "user1@mail.ru", new Car("opel", 55)));
        userService.addUser(new User("User2", "Lastname2", "user2@mail.ru", new Car("ford", 44)));
        userService.addUser(new User("User3", "Lastname3", "user3@mail.ru", new Car("lada", 13)));
        userService.addUser(new User("User4", "Lastname4", "user4@mail.ru", new Car("Toyota", 87)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());

            Car car = user.getCar();
            if (car != null) {
                System.out.println("Car model = " + car.getModel());
                System.out.println("Model series = " + car.getSeries());
            }
            System.out.println();

        }
        List<User> result = userService.findUserBySeriesByModel("Toyota", 87);
        for (User user : result) {
            System.out.println("User with Toyota 87: " + user.getFirstName());
            context.close();
        }
    }
}
