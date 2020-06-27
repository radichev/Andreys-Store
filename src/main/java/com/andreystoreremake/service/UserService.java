package com.andreystoreremake.service;

import com.andreystoreremake.domain.serviceModel.UserServiceModel;

public interface UserService {
    UserServiceModel register(UserServiceModel userServiceModel);


    UserServiceModel findByUsername(String username);
}
