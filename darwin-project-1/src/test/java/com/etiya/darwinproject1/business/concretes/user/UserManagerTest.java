package com.etiya.darwinproject1.business.concretes.user;

import com.etiya.darwinproject1.business.abstracts.common.GnlStService;
import com.etiya.darwinproject1.business.abstracts.common.GnlTpService;
import com.etiya.darwinproject1.business.dtos.requests.user.CreateUserRequest;
import com.etiya.darwinproject1.business.dtos.response.user.CreateUserResponse;
import com.etiya.darwinproject1.business.dtos.response.user.UserInfoResponse;
import com.etiya.darwinproject1.business.dtos.response.user.UserLoginResponse;
import com.etiya.darwinproject1.core.exceptions.types.BusinessException;
import com.etiya.darwinproject1.core.internationalization.MessageService;
import com.etiya.darwinproject1.core.utilities.mappers.mapstruct.UserMapper;
import com.etiya.darwinproject1.entities.concretes.common.GnlSt;
import com.etiya.darwinproject1.entities.concretes.common.GnlTp;
import com.etiya.darwinproject1.entities.concretes.user.UserSpec;
import com.etiya.darwinproject1.repositories.abstracts.common.GnlTpDao;
import com.etiya.darwinproject1.repositories.abstracts.user.UserDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserManagerTest {

    @InjectMocks
    private UserManager userManager;
    @Mock
    private UserDao userDao;
    @Mock
    private MessageService messageService;
    @Mock
    private GnlStService gnlStService;
    @Mock
    private GnlTpService gnlTpService;
    @Mock
    private UserMapper userMapper;
    @Mock
    private GnlTpDao gnlTpDao;

    @Test
    void inquireUserTypes() {
        String name = "TestName";
        List<UserInfoResponse> someResult = new ArrayList<>();
        when(userDao.inquireUserTypes(name)).thenReturn(someResult);
        when(gnlTpDao.findByName(name)).thenReturn(new GnlTp());
        ResponseEntity<Object> response = userManager.inquireUserTypes(name);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void createUser() {
        CreateUserRequest createUserRequest = new CreateUserRequest("General", "TestUser", "TestPassword");
        GnlSt gnlSt = new GnlSt();
        when(userDao.findByUname(createUserRequest.getUname())).thenReturn(null);
        when(gnlStService.statusActive()).thenReturn(gnlSt);
        UserSpec userSpec = new UserSpec();
        when(userMapper.requestToModel(createUserRequest)).thenReturn(userSpec);
        CreateUserResponse createUserResponse = new CreateUserResponse();
        when(userMapper.modelToResponse(userSpec)).thenReturn(createUserResponse);

        ResponseEntity<Object> response = userManager.createUser(createUserRequest);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(userDao, times(1)).findByUname(createUserRequest.getUname());
        verify(gnlStService, times(1)).statusActive();
        verify(userDao, times(1)).save(userSpec);
        verify(userMapper, times(1)).modelToResponse(userSpec);
    }

    @Test
    void inquireUser() {
        String uname = "TestUser";
        String pwd = "TestPassword";
        UserLoginResponse userLoginResponse = new UserLoginResponse();

        when(userDao.inquireUser(uname, pwd)).thenReturn(userLoginResponse);

        ResponseEntity<Object> response = userManager.inquireUser(uname, pwd);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        //assertEquals(expectedResult, response.getBody());
        verify(userDao, times(1)).inquireUser(uname, pwd);
    }

    @Test
    void testIsAdminWhenAdminUserReturnsTrue() {
        Long userId = 1L;
        UserSpec adminUser = new UserSpec();
        GnlTp gnlTp = new GnlTp();
        gnlTp.setId(2l);
        adminUser.setGnlTp(gnlTp);

        when(userDao.isAdmin(userId)).thenReturn(adminUser);
        when(gnlTpService.typeAdmin()).thenReturn(gnlTp);

        boolean isAdmin = userManager.isAdmin(userId);

        assertTrue(isAdmin);
        verify(userDao, times(1)).isAdmin(userId);
    }

    @Test
    void testIsAdminWhenGeneralUserReturnsFalse() {
        Long userId = 1L;
        UserSpec generalUser = new UserSpec();
        GnlTp gnlTp = new GnlTp();
        gnlTp.setId(1l);
        generalUser.setGnlTp(gnlTp);

        when(userDao.isAdmin(userId)).thenReturn(generalUser);
        when(gnlTpService.typeAdmin()).thenReturn(gnlTp);

        boolean isAdmin = userManager.isAdmin(userId);

        assertFalse(isAdmin);
        verify(userDao, times(1)).isAdmin(userId);
    }

    @Test
    void testCheckIfUserWithUserIdExistsWhenUserExistsDoesNotThrowException() {
        Long userId = 1L;

        when(userDao.existsUserById(userId)).thenReturn(true);

        assertDoesNotThrow(() -> userManager.checkIfUserWithUserIdExists(userId));

        verify(userDao, times(1)).existsUserById(userId);
    }

    @Test
    void testCheckIfUserWithUserIdExistsWhenUserDoesNotExistThrowsException() {
        Long userId = 1L;

        when(userDao.existsUserById(userId)).thenReturn(false);

        assertThrows(BusinessException.class, () -> userManager.checkIfUserWithUserIdExists(userId));

        verify(userDao, times(1)).existsUserById(userId);
    }

    @Test()
    void testGetUserBySelectedOfferIdWhenSelectedOfferIdExistsReturnsUserSpec() {
        Long selectedOfferId = 1L;
        UserSpec userSpec = new UserSpec();

        when(userDao.getSelectedOfferUser(selectedOfferId)).thenReturn(userSpec);
        when(userDao.findBySelectedOfferId(selectedOfferId)).thenReturn(userSpec);
        UserSpec result = userManager.getUserBySelectedOfferId(selectedOfferId);

        assertEquals(userSpec, result);

        verify(userDao, times(1)).getSelectedOfferUser(selectedOfferId);
    }

    @Test
    public void testGetUserBySelectedOfferIdWhenSelectedOfferIdDoesNotExistThrowsException() {
        Long selectedOfferId = 1L;

        when(userDao.findBySelectedOfferId(selectedOfferId)).thenReturn(null);

        assertThrows(BusinessException.class, () -> userManager.getUserBySelectedOfferId(selectedOfferId));

        verify(userDao, times(1)).findBySelectedOfferId(selectedOfferId);
    }
}