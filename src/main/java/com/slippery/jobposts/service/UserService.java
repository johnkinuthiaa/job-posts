package com.slippery.jobposts.service;

import com.slippery.jobposts.dto.UserDto;
import com.slippery.jobposts.model.User;

public interface UserService {
    UserDto register(User user);
    UserDto login(User user);
}
