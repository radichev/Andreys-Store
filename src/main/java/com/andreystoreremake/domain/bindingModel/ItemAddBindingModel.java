package com.andreystoreremake.domain.bindingModel;

import com.andreystoreremake.domain.entity.CategoryName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ItemAddBindingModel {
    private String name;
    private String description;
    private BigDecimal price;
    private String gender;
    private CategoryName category;

    public ItemAddBindingModel() {
    }

    @Length(min = 2, message = "Name length must be more than two characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 3, message = "Description length must be more than three characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DecimalMin(value = "0", message = "Price must be positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @NotNull
    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }
}
