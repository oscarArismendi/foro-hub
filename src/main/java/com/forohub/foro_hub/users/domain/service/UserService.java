package com.forohub.foro_hub.users.domain.service;

import com.forohub.foro_hub.users.domain.dto.UserRequest;
import com.forohub.foro_hub.users.domain.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest request);
}
