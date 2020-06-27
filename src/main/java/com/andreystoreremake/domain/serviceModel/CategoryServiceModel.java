package com.andreystoreremake.domain.serviceModel;

import com.andreystoreremake.domain.entity.CategoryName;

import javax.validation.constraints.NotNull;

public class CategoryServiceModel extends BaseServiceModel {
    private CategoryName name;
    private String description;

    public CategoryServiceModel() {
    }

    @NotNull
    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
