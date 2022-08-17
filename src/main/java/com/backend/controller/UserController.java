package com.backend.controller;

import com.backend.domain.User;
import com.backend.dto.Login;
import com.backend.exceptions.UserNotFoundException;
import com.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user/")
public class UserController {
    private final UserService userService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody User user){
        return this.userService.save(user);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User update(@RequestBody User user) throws UserNotFoundException {
        return this.userService.update(user);
    }

    @PutMapping(value = "login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User login(@RequestBody Login login) throws UserNotFoundException {
        return this.userService.login(login);
    }

}
