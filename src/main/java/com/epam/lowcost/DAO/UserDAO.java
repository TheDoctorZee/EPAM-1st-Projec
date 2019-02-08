package com.epam.lowcost.DAO;

import com.epam.lowcost.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
}
