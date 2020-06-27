package com.andreystoreremake.service;

import com.andreystoreremake.domain.serviceModel.ItemServiceModel;
import com.andreystoreremake.domain.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    void addItem(ItemServiceModel itemServiceModel);

    ItemServiceModel findByName(String name);

    List<ItemViewModel> findAllItems();

    ItemViewModel findById(String id);

    void delete(String id);
}
