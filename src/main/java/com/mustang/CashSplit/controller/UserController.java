package com.mustang.CashSplit.controller;

import com.mustang.CashSplit.input.UserGroupInput;
import com.mustang.CashSplit.input.UserInput;
import com.mustang.CashSplit.model.User;
import com.mustang.CashSplit.model.UserGroup;
import com.mustang.CashSplit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @MutationMapping
    public Mono<ResponseEntity<Void>> createUser(@Argument("input") UserInput userInput){
        User user = User.builder()
                .userId(UUID.randomUUID().toString())
                .userName(userInput.username())
                .name(userInput.name())
                .phoneNumber(userInput.phoneNumber())
                .isNew(true)
                .build();
        return this.userService.createUser(user)
                .then(Mono.just(new ResponseEntity<>( HttpStatus.OK)));
    }

    @MutationMapping
    public Mono<ResponseEntity<Void>> addUserToGroup(@Argument("input")UserGroupInput userGroupInput){
        UserGroup userGroup = UserGroup.builder()
                .groupId(userGroupInput.groupId())
                .userId(userGroupInput.userId())
                .isNew(true)
                .build();
        return this.userService.addUserToGrop(userGroup)
                .then(Mono.just(new ResponseEntity<>(HttpStatus.OK)));
    }
}
