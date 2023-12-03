package com.ute.ecwebapp.models;

import com.ute.ecwebapp.beans.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CategoryModel {
    public static List<Category> findAll() {
    return new ArrayList<>(
            Arrays.asList(
                    new Category(1, "Điện thoại"),
                    new Category(2, "Laptop"),
                    new Category(3, "Máy tính bảng"),
                    new Category(4, "Phụ kiện"),
                    new Category(5, "Đồng hồ")
            )
        );
    }
}
