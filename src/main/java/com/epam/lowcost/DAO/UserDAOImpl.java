package com.epam.lowcost.DAO;

import com.epam.lowcost.model.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private BasicDataSource basicDataSource;

    public UserDAOImpl(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        User user;
        try (Connection conn = basicDataSource.getConnection();
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM EMPLOYEES")) {


            while (rs.next()) {
                Long id = rs.getLong("id");
                String first = rs.getString("first");
                String last = rs.getString("last");
                System.out.println("we got =  " + id + first + last);
                user = new User(id, first, last);
                System.out.println(user);
                allUsers.add(user);

            }
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsers;
    }
}
