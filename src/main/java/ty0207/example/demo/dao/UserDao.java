package ty0207.example.demo.dao;

import ty0207.example.demo.entity.User;

import java.util.List;

public interface UserDao {
    User createUser(User user);
    boolean modifyUser(User user);
    List<User> findByName(String name);
    List<User> findAll();
}
