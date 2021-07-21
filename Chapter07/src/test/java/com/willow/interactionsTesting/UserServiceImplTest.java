package com.willow.interactionsTesting;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    private UserDAO userDAO;
    private SecurityService securityService;
    private UserServiceImpl userService;

    @BeforeEach
    void setUp(){
        userDAO = mock(UserDAO.class);
        securityService = mock(SecurityService.class);
        userService = new UserServiceImpl(userDAO, securityService);
    }

    @ParameterizedTest
    @CsvSource({"pana, 4f7a15eXnGz7tQwKDE3XArwG4KNiEiB5Ubvf48"})
    void shouldChangeMD5PaswordWhenIsOK(String original, String md5) throws Exception {
        User user = new User("NOSE", original);
        when(securityService.md5(original)).thenReturn(md5);

        userService.assignPassword(user);
        assertThat(user.getPassword()).isEqualTo(md5);
        verify(securityService, times(1)).md5(original);
        verify(userDAO, times(1)).updateUser(user);
    }

    @ParameterizedTest
    @ValueSource(strings = "pana")
    void shouldThrownExceptionWhenErrorInMD5(String original) throws Exception {
        User user = new User("nose", original);
        when(securityService.md5(original)).thenThrow(Exception.class);

        assertThatExceptionOfType(Exception.class).isThrownBy(
                ()->userService.assignPassword(user)
        );

        verify(securityService, times(1)).md5(original);
        verify(userDAO, never()).updateUser(user);

    }

    @ParameterizedTest
    @CsvSource({"pana, 4f7a15eXnGz7tQwKDE3XArwG4KNiEiB5Ubvf48"})
    void shouldThrownExceptionWhenErrorInUpdateUser(String original, String md5) throws Exception {
        User user = new User("nose", original);
        when(securityService.md5(original)).thenReturn(md5);
       doThrow(Exception.class).when(userDAO).updateUser(user);

        assertThatExceptionOfType(Exception.class).isThrownBy(
                ()->userService.assignPassword(user)
        );

        verify(securityService, times(1)).md5(original);
        verify(userDAO,times(1)).updateUser(user);

    }

}