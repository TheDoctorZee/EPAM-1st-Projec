package com.epam.lowcost.db;


import org.apache.commons.dbcp2.BasicDataSource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class DBinitialize {

    private BasicDataSource basicDataSource;
    private Connection conn;
    private Statement stm;

    public DBinitialize(BasicDataSource basicDataSource) throws SQLException {
        this.basicDataSource = basicDataSource;
        conn = basicDataSource.getConnection();
        stm = conn.createStatement();
        initiateDB();


    }


    public void initiateDB() throws SQLException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\Ilia_Stepanov\\IdeaProjects\\EPAM-1st-Projec\\src\\main\\resources\\createTable"))) {

            String sql = br.readLine();
            while (sql != null) {
                stm.addBatch(sql);
                sql = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        stm.executeBatch();
        ResultSet rs = stm.executeQuery("SELECT * FROM REGISTRATION");
        ResultSetMetaData rsm = rs.getMetaData();
        int columnsNumber = rsm.getColumnCount() + 1;
        while (rs.next()) {
            for (int i = 1; i < columnsNumber; i++) {
                System.out.print(" " + rs.getMetaData().getColumnName(i) + "=" + rs.getObject(i));
            }
            System.out.println();
        }


    }


}



