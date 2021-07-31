package com.willow.collections;


import com.willow.interactionsTesting.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserListTest {
    UserList userList;

    @BeforeEach
    void setUp(){
        userList = new UserList();
    }

    @Test
    void shouldReturnEmptyListWhenNotElements(){
        assertThat(userList.getUsers()).isEmpty();
    }

    @Test
    void shouldReturnOneElementWhenOneElementIsAdded(){
        List<User> generatedUsers = generateUsers(1);
        userList.addUser(generatedUsers.get(0));

        assertThat(userList.getUsers()).hasSameSizeAs(generatedUsers);
    }


    @Test
    void shouldReturnTwoElementsWhenTwoElementsAreAdded(){
        List<User> generatedUsers = generateUsers(2);

        for(var i=0; i <2; i++){
            userList.addUser(generatedUsers.get(i));
        }

        assertThat(userList.getUsers()).hasSameSizeAs(generatedUsers);

    }

    private List<User> generateUsers(int num){
        List<User> generatedUsers = new ArrayList<>();
        for(var i=0; i < num; i++){
            User user = new User(""+i,"");
            generatedUsers.add(user);
        }
        return generatedUsers;
    }
}