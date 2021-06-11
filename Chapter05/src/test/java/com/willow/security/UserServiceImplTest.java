package com.willow.security;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    private final static String PASSWORD = "password";
    private final static String MD5 = "5f4dcc3b5aa765d61d8327deb882cf99";

    private UserDAO userDAO = mock(UserDAO.class);
    private SecurityService securityService = mock(SecurityService.class);
    private User user = new User(PASSWORD);
    private UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);

    @Test
    void passwordShouldBeUpdateToMD5() throws Exception {
        when(securityService.md5(PASSWORD)).thenReturn(MD5);

        userService.assignPassword(user);

        assertThat(user.getPassword()).isEqualTo(MD5);
        verify(userDAO).updateUser(user);
    }
}