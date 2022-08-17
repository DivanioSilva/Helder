package com.backend.service;

import com.backend.domain.User;
import com.backend.dto.Login;
import com.backend.exceptions.UserNotFoundException;
import com.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User save(User user) {
        user.setId(null);
        return this.userRepository.save(user);
    }

    public User update(User user) throws UserNotFoundException {
        User userOnDB = this.userRepository
                .findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("I cannot find any user with this id: "+ user.getId()));
        userOnDB.setEmail(user.getEmail());
        userOnDB.setFirstName(user.getFirstName());
        userOnDB.setLastName(user.getLastName());
        userOnDB.setPhoneNumber(user.getPhoneNumber());
        return this.userRepository.save(userOnDB);
    }

    public User login(Login login) throws UserNotFoundException {
        return this.userRepository
                .findByFirstNameAndPassword(login.getUserName(), login.getPassword())
                .orElseThrow(() -> new UserNotFoundException("Wrong login or password"));
    }
}
