package com.example.pizzaapp.services;

import com.example.pizzaapp.models.User;
import com.example.pizzaapp.repositories.OrderRepository;
import com.example.pizzaapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public boolean createUser(String firstname, String lastname, String email,
                              String password, Date birthday) {
        try {
            User user = new User(
                    firstname,
                    lastname,
                    birthday,
                    email,
                    password
            );

            userRepository.save(user);

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean updateUser(Long id, String email, String password, String firstname,
                              String lastname, Date birthdate) {
        try {
            User user = userRepository.findById(id).get();
            user.setEmail(email);
            user.setPassword(password);
            user.setFirstname(firstname);
            user.setSurname(lastname);
            user.setBirthdate(birthdate);

            userRepository.save(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean deleteUser(Long id) {
        try {

            User user = userRepository.findById(id).get();
            orderRepository.deleteAllByUser(user);
            userRepository.delete(user);

            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
