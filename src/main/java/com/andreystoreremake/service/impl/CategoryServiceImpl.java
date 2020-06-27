package com.andreystoreremake.service.impl;

import com.andreystoreremake.domain.entity.Category;
import com.andreystoreremake.domain.entity.CategoryName;
import com.andreystoreremake.repository.CategoryRepository;
import com.andreystoreremake.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void initCategories() {
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values())
                    .forEach(name -> {
                        this.categoryRepository
                                .save(new Category(name,
                                        String.format("Description for %s", name.name())));
                    });
        }
    }

    @Override
    public Category findByName(CategoryName categoryName) {
        return this.categoryRepository.findByName(categoryName)
                .orElse(null);
    }
}
