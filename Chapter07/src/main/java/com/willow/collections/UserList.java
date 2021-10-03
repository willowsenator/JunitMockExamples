package com.willow.collections;

import com.willow.interactionsTesting.User;
import java.util.ArrayList;
import java.util.List;

public class UserList {
    private final List<User> users = new ArrayList<>();

    public List<User> getUsers(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }
}
