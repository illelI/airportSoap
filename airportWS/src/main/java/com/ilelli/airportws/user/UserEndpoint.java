package com.ilelli.airportws.user;

import jakarta.transaction.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
class UserEndpoint {
    private static final String NAMESPACE = "http://ilelli.com/airport/user";
    private final UserService userService;

    UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    @PayloadRoot(namespace = NAMESPACE, localPart = "register")
    @ResponsePayload
    public UserResponse registerUser(@RequestPayload RegisterRequest request) {
        UserResponse response = new UserResponse();
        response.setId(userService.register(request));
        return response;
    }



}
