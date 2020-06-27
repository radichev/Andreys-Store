package com.andreystoreremake.service;

import com.andreystoreremake.domain.entity.Category;
import com.andreystoreremake.domain.entity.CategoryName;
import com.andreystoreremake.domain.serviceModel.CategoryServiceModel;

import java.util.Optional;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryName categoryName);
}
