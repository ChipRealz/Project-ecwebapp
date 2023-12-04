package com.ute.ecwebapp.utils;

import org.sql2o.Sql2o;
import org.sql2o.Connection;

public class DbUtils {
    static Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/qlbh", "root", "root");

    public static Connection getConnection() {
        return sql2o.open();
    }
}
