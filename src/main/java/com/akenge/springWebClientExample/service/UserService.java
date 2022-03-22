package com.akenge.springWebClientExample.service;

import com.akenge.springWebClientExample.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserService {

    private final WebClient webClient;

    public UserService(WebClient.Builder builder) {

        webClient = builder.baseUrl("https://jsonplaceholder.typicode.com/").build();
    }

    public User[] getUsers(){

        return webClient
                .get()
                .uri("/users")
                .retrieve()
                .bodyToMono(User[].class)
                .block();
    }
}
