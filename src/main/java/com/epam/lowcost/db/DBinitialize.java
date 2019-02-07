package com.epam.lowcost.db;


import org.apache.commons.dbcp2.BasicDataSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBinitialize {

    private Connection conn;
    private Statement stm;

    public DBinitialize(BasicDataSource basicDataSource) throws SQLException {

        conn = basicDataSource.getConnection();
        stm = conn.createStatement();
        initiateDB();
        printAllDb();
    }


    private void initiateDB() throws SQLException {
        File fl = new File(this.getClass().getResource("/createTable").getFile());
        List<String> sqlBatch = new ArrayList<>();
        try (Stream<String> str = Files.lines(fl.toPath())) {
            str.forEach(sqlBatch::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : sqlBatch) {
            stm.addBatch(s);
        }

        stm.executeBatch();
    }

    private void printAllDb() {
        List<String> tables = new ArrayList<>();
        try {
            DatabaseMetaData dm = conn.getMetaData();
            ResultSet rs = dm.getTables(null, null, "%", null);
            while (rs.next()) {
                if (rs.getString(4).equalsIgnoreCase("TABLE")) {
                    tables.add(rs.getString(3));
                }
            }
            ResultSetMetaData rsm;
            for (String s : tables) {
                System.out.println(String.format("=================%s==============", s));
                rs = stm.executeQuery("SELECT * FROM " + s);
                rsm = rs.getMetaData();
                int columns = rsm.getColumnCount() + 1;

                while (rs.next()) {
                    for (int i = 1; i < columns; i++) {
                        System.out.print(" " + rs.getMetaData().getColumnName(i) + "=" + rs.getObject(i));
                    }
                    System.out.println();
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}



