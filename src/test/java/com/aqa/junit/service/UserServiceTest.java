package com.aqa.junit.service;

import com.aqa.junit.dto.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {

    private UserService userService;

    @BeforeAll
    void init(){
        System.out.println("Before all " + this);
    }

    @Test
    void userEmptyIfNoUserAdded(){
        userService = new UserService();
        var users =  userService.getAll();
        assertTrue(users.isEmpty());
        System.out.println("Success 1 " + this);
    }

    @Test
    void userSizeIfUserAdded(){
        userService = new UserService();
        userService.add(new User());
        userService.add(new User());

        var userServiceAll = userService.getAll();
        assertEquals(2, userServiceAll.size());
        System.out.println("Success 2 " + this);
    }

    @AfterAll
    void closeResources(){
        System.out.println("After all " + this);
    }
}
