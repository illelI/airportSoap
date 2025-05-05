package com.ilelli.airportws.user;

import org.springframework.stereotype.Service;

@Service
class UserService {

    public String register(RegisterRequest request) {
        User user = requestToUser(request);
        return user.getId().toString();
    }

    private User requestToUser(RegisterRequest request) {
        User user = new User();
        user.setLogin(request.getUsername());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        return user;
    }
}
