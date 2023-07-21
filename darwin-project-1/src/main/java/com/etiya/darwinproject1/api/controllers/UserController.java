package com.etiya.darwinproject1.api.controllers;

import com.etiya.darwinproject1.business.abstracts.user.UserService;
import com.etiya.darwinproject1.business.dtos.requests.user.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("inquireUserTypes")
    public ResponseEntity<Object> inquireUserTypes(@RequestParam(required = false) String screenFlowShortCode) {return userService.inquireUserTypes(screenFlowShortCode);}

    @PostMapping("createUser")
    public ResponseEntity<Object> createUser(@RequestBody CreateUserRequest createUserRequest) {
        return userService.createUser(createUserRequest);
    }

    @PostMapping("inquireUser")
    public ResponseEntity<Object> inquireUser(@RequestParam(required = false) String userName,
                                              @RequestParam(required = false) String password) {
        return userService.inquireUser(userName, password);
    }
}
