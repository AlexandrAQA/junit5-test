package com.aqa.junit.service;

import com.aqa.junit.dto.User;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {

    private static final User MARK = User.of(1, "Mark", "111212121");
    private static final User MAX = User.of(2, "Max", "2221212121");
    private UserService userService = new UserService();

    @BeforeAll
    void init(){
        System.out.println("Before all " + this);
    }

    @Test
    void userEmptyIfNoUserAdded(){
        var users =  userService.getAll();
        assertTrue(users.isEmpty());
        System.out.println("Success 1 " + this);
    }

    @Test
    void userSizeIfUserAdded(){
        userService.add(MARK);
        userService.add(MAX);
        var userServiceAll = userService.getAll();
        assertEquals(4, userServiceAll.size());
        System.out.println("Success 2 " + this);
    }

    @Test
    void loginSuccessIfUserExists(){
        userService.add(MARK);
        Optional<User> userOptional = userService.login(MARK.getUsername(), MARK.getPassword());
        assertTrue(userOptional.isPresent());
        Assertions.assertEquals(userOptional, MARK);

    }

    @Test
    void loginFailedIfUserIsNotCorrect(){
        userService.add(MAX);
        var maybeUser = userService.login(MAX.getUsername(), "ssss");
        assertTrue(maybeUser.isEmpty());

    }

    @Test
    void loginFailedIfUserDoesNotExist(){
        userService.add(MAX);
        var maybeUser = userService.login("invalidUser", MARK.getPassword());
        assertTrue(maybeUser.isEmpty());
    }

    @AfterAll
    void closeResources(){
        System.out.println("After all " + this);
    }
}
