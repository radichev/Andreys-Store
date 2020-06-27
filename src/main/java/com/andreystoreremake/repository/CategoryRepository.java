package com.andreystoreremake.repository;

import com.andreystoreremake.domain.entity.Category;
import com.andreystoreremake.domain.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Optional<Category> findByName(CategoryName categoryName);
}
