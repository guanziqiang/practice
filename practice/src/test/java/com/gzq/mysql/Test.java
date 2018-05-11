package com.gzq.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
    public static final String url = "jdbc:mysql://192.168.0.149:3306/practice";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "gzq123";

    public static void main(String[] args) {

        try {
            Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } // 指定连接类型
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
