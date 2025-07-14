package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);
   List<User> makeListUsers();
   List <User> findUserBySeriesByModel(String model, int series);
}
