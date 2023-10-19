package com.aqa.junit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    void userEmptyIfNoUserAdded(){
        var userService = new UserService();
        var users =  userService.getAll();
        Assertions.assertTrue(users.isEmpty());

    }
}
