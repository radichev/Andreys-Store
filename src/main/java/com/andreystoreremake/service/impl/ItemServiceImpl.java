package com.andreystoreremake.service.impl;

import com.andreystoreremake.domain.entity.Item;
import com.andreystoreremake.domain.serviceModel.ItemServiceModel;
import com.andreystoreremake.domain.view.ItemViewModel;
import com.andreystoreremake.repository.ItemRepository;
import com.andreystoreremake.service.CategoryService;
import com.andreystoreremake.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        Item item = this.modelMapper.map(itemServiceModel, Item.class);

        item.setCategory(this.categoryService.findByName(itemServiceModel.getCategory().getName()));

        this.itemRepository.saveAndFlush(item);
    }

    @Override
    public ItemServiceModel findByName(String name) {
        return this.itemRepository.findByName(name)
                .map(item -> this.modelMapper.map(item, ItemServiceModel.class))
                .orElse(null);
    }

    @Override
    public List<ItemViewModel> findAllItems() {
        return this.itemRepository.findAll()
                .stream()
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getName()));

                    return itemViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(String id) {
        return this.itemRepository.findById(id)
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getName()));

                    return itemViewModel;
                })
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        this.itemRepository.deleteById(id);
    }
}
