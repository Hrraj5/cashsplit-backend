package com.mustang.CashSplit.controller;

import com.mustang.CashSplit.dto.GroupDto;
import com.mustang.CashSplit.input.GroupInput;
import com.mustang.CashSplit.model.Group;
import com.mustang.CashSplit.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @MutationMapping
    public Mono<GroupDto> createGroup(@Argument("input") GroupInput groupInput) {
        Group group = Group.builder().
                groupId(UUID.randomUUID().toString()).
                groupName(groupInput.groupName()).
                description(groupInput.groupDescription()).
                active(true).
                isNew(true).
                build();
        return this.groupService.createGroup(group);
    }
}
