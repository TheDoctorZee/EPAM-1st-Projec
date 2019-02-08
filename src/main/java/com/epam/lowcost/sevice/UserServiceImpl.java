package com.epam.lowcost.sevice;

import com.epam.lowcost.DAO.UserDAOImpl;
import com.epam.lowcost.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAOImpl userDAO;

    public UserServiceImpl(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("service print");
        return userDAO.getAllUsers();
    }
}
