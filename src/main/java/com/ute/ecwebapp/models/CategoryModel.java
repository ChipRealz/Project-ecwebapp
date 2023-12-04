package com.ute.ecwebapp.models;

import com.ute.ecwebapp.beans.Category;
import com.ute.ecwebapp.utils.DbUtils;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CategoryModel {
    //    public static List<Category> findAll() {
//    return new ArrayList<>(
//            Arrays.asList(
//                    new Category(1, "Điện thoại"),
//                    new Category(2, "Laptop"),
//                    new Category(3, "Máy tính bảng"),
//                    new Category(4, "Phụ kiện"),
//                    new Category(5, "Đồng hồ")
//            )
//        );
//    }
//}
    public static List<Category> findAll() {
        String sql = "select * from categories";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(sql).executeAndFetch(Category.class);
        }
    }

    public static Category findById(int id) {
        String sql = "select * from categories where CatID = :CatID";
        try (Connection con = DbUtils.getConnection()) {
            List<Category> list = con.createQuery(sql)
                    .addParameter("CatID", id)
                    .executeAndFetch(Category.class);

            if (list.size() == 0)
                return null;

            return list.get(0);
        }
    }

    public static void add(Category c) {
        String sql = "insert into categories(CatName) values(:CatName)";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("CatName", c.getCatName())
                    .executeUpdate();
        }
    }

    public static void update(Category c) {
        String sql = "UPDATE categories SET  CatName = :CatName WHERE CatID = :CatID";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("CatName", c.getCatName())
                    .addParameter("CatID", c.getCatID())
                    .executeUpdate();
        }
    }

    public static void delete(int id) {
        String sql = "delete from categories where CatID = :CatID";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("CatID", id)
                    .executeUpdate();
        }
    }
}