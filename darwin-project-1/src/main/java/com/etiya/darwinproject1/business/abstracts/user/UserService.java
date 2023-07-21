package com.etiya.darwinproject1.business.abstracts.user;

import com.etiya.darwinproject1.business.dtos.requests.user.CreateUserRequest;
import com.etiya.darwinproject1.entities.concretes.user.UserSpec;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<Object> inquireUserTypes(String name);

    ResponseEntity<Object> createUser(CreateUserRequest createUserRequest);

    ResponseEntity<Object> inquireUser(String uname, String pwd);

    Boolean isAdmin(Long userId);

    void checkIfUserWithUserIdExists(Long userId);

    UserSpec getUserBySelectedOfferId(Long selectedOfferId);
}
