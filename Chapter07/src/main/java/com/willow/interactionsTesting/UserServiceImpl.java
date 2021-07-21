package com.willow.interactionsTesting;

public class UserServiceImpl implements UserService{
    private UserDAO userDAO;
    private SecurityService securityService;

    UserServiceImpl(UserDAO userDAO, SecurityService securityService){
        this.userDAO = userDAO;
        this.securityService = securityService;
    }

    @Override
    public void assignPassword(User user) throws Exception {
        String passwordMd5 = securityService.md5(user.getPassword());
        user.setPassword(passwordMd5);
        userDAO.updateUser(user);
    }
}
