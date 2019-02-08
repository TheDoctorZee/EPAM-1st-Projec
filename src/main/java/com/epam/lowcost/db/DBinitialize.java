package com.epam.lowcost.db;


import com.epam.lowcost.DAO.UserDAOImpl;
import com.epam.lowcost.sevice.UserServiceImpl;
import lombok.Cleanup;
import lombok.Data;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DBinitialize {
    BasicDataSource basicDataSource;
    private Connection conn;
    private Statement stm;

    private UserServiceImpl userService;

    public DBinitialize(BasicDataSource basicDataSource, UserServiceImpl userService) {
        this.basicDataSource = basicDataSource;
        this.userService = userService;
        initiateDB();
        printFromServ();

    }


    private void initiateDB() {
        File fl = new File(this.getClass().getResource("/createTable").getFile());
        List<String> sqlBatch = new ArrayList<>();
        try {
             conn = basicDataSource.getConnection();
            stm = conn.createStatement();
            try (Stream<String> str = Files.lines(fl.toPath())) {
                str.forEach(sqlBatch::add);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                for (String s : sqlBatch) {
                    stm.addBatch(s);
                }
                stm.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void printFromServ(){
        userService.getAllUsers().forEach(s-> System.out.println(s));
    }

//    private void printAllDb() {
//        List<String> tables = new ArrayList<>();
//        try {
//            conn = basicDataSource.getConnection();
//            stm = conn.createStatement();
//
//            DatabaseMetaData dm = conn.getMetaData();
//            ResultSet rs = dm.getTables(null, null, "%", null);
//            while (rs.next()) {
//                if (rs.getString(4).equalsIgnoreCase("TABLE")) {
//                    tables.add(rs.getString(3));
//                }
//            }
//            ResultSetMetaData rsm;
//            for (String s : tables) {
//                System.out.println(String.format("=================%s==============", s));
//                rs = stm.executeQuery("SELECT * FROM " + s);
//                rsm = rs.getMetaData();
//                int columns = rsm.getColumnCount() + 1;
//
//                while (rs.next()) {
//                    for (int i = 1; i < columns; i++) {
//                        System.out.print(" " + rs.getMetaData().getColumnName(i) + " = " + rs.getObject(i));
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//                if (stm != null) {
//                    stm.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

}



