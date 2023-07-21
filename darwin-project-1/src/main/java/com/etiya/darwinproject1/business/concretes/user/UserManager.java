package com.etiya.darwinproject1.business.concretes.user;

import com.etiya.darwinproject1.business.abstracts.common.GnlStService;
import com.etiya.darwinproject1.business.abstracts.common.GnlTpService;
import com.etiya.darwinproject1.business.abstracts.user.UserService;
import com.etiya.darwinproject1.business.constants.Messages;
import com.etiya.darwinproject1.business.dtos.requests.user.CreateUserRequest;
import com.etiya.darwinproject1.business.dtos.response.user.CreateUserResponse;
import com.etiya.darwinproject1.business.dtos.response.user.UserLoginResponse;
import com.etiya.darwinproject1.core.exceptions.types.BusinessException;
import com.etiya.darwinproject1.core.internationalization.MessageService;
import com.etiya.darwinproject1.core.utilities.mappers.mapstruct.UserMapper;
import com.etiya.darwinproject1.core.utilities.responseHandler.ResponseHandler;
import com.etiya.darwinproject1.entities.concretes.user.UserSpec;
import com.etiya.darwinproject1.repositories.abstracts.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserManager implements UserService {

    private final UserDao userDao;
    private final MessageService messageService;
    private final GnlStService gnlStService;
    private final GnlTpService gnlTpService;
    private final UserMapper userMapper;

    @Autowired
    public UserManager(UserDao userDao, MessageService messageService, GnlStService gnlStService, GnlTpService gnlTpService, UserMapper userMapper) {
        this.userDao = userDao;
        this.messageService = messageService;
        this.gnlStService = gnlStService;
        this.gnlTpService = gnlTpService;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<Object> inquireUserTypes(String name) {
        gnlTpService.checkUserType(name);
        ResponseEntity<Object> responseEntity = ResponseHandler.responseBuilder(messageService.getMessage(Messages.User.UsersListed), HttpStatus.OK, userDao.inquireUserTypes(name));
        return responseEntity;
    }

    @Override
    public ResponseEntity<Object> createUser(CreateUserRequest createUserRequest) {
        checkIfUserWithUserNameExists(createUserRequest.getUname());
        UserSpec userSpec = userMapper.requestToModel(createUserRequest);
        checkUserTypeGeneralOrAdmin(createUserRequest, userSpec);
        userSpec.setGnlSt(gnlStService.statusActive());
        userDao.save(userSpec);
        CreateUserResponse response = userMapper.modelToResponse(userSpec);
        return ResponseHandler.responseBuilder(messageService.getMessage(Messages.User.UserCreated), HttpStatus.CREATED, response);
    }

    @Override
    public ResponseEntity<Object> inquireUser(String uname, String pwd) {
        checkIfUserNameOrPasswordNull(new ArrayList<>(Arrays.asList(uname, pwd)));
        UserLoginResponse response = userDao.inquireUser(uname, pwd);
        return new ResponseEntity<>(userNameAndPasswordMatch(response), HttpStatus.OK);
    }

    @Override
    public Boolean isAdmin(Long userId) {
        UserSpec userSpec = userDao.isAdmin(userId);
        if (userSpec.getGnlTp().getId() == 2) {
            return true;
        } else return false;
    }

    @Override
    public void checkIfUserWithUserIdExists(Long userId) {
        boolean isUserExists = userDao.existsUserById(userId);
        if (!isUserExists)
            throw new BusinessException(messageService.getMessageWithParams(Messages.User.UserIdDoesNotExists, userId));
    }

    @Override
    public UserSpec getUserBySelectedOfferId(Long selectedOfferId) {
        checkIfSelectedOfferIdDoesNotExists(selectedOfferId);
        UserSpec userSpec = userDao.getSelectedOfferUser(selectedOfferId);
        return userSpec;
    }

    private void checkIfSelectedOfferIdDoesNotExists(Long selectedOfferId) {
        UserSpec selectedOfferIdToFind = userDao.findBySelectedOfferId(selectedOfferId);
        if (selectedOfferIdToFind == null) {
            throw new BusinessException(messageService.getMessageWithParams(Messages.Order.SelectedOfferIdDoesNotExists, selectedOfferId));
        }
    }

    private void checkIfUserNameOrPasswordNull(List<Object> paramaters) {
        if (paramaters.stream().allMatch(param -> param == null)) {
            throw new BusinessException(messageService.getMessage(Messages.User.UserNameAndPwdMustBeEntered));
        }
    }

    private ResponseEntity<Object> userNameAndPasswordMatch(UserLoginResponse response) {
        if (response == null) {
            return ResponseHandler.responseBuilder(messageService.getMessage(Messages.ErrorMessages.UserNameOrPasswordAreWrong), HttpStatus.NOT_FOUND, null);
        } else
            return ResponseHandler.responseBuilder(messageService.getMessage(Messages.User.UserProfile), HttpStatus.OK, response);
    }

    private void checkIfUserWithUserNameExists(String uname) {
        UserSpec unameToFind = userDao.findByUname(uname);
        if (unameToFind != null)
            throw new BusinessException(messageService.getMessage(Messages.User.UserNameExists));
    }

    private void checkUserTypeGeneralOrAdmin(CreateUserRequest createUserRequest, UserSpec userSpec) {
        if (createUserRequest.getName().equals("Admin")) {
            userSpec.setGnlTp(gnlTpService.typeAdmin());

        } else if (createUserRequest.getName().equals("General")) {
            userSpec.setGnlTp(gnlTpService.typeUser());

        } else {
            throw new BusinessException(messageService.getMessage(Messages.ErrorMessages.UserTypeNotValid));
        }
    }
}
