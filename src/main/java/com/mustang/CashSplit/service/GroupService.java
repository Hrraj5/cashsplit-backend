package com.mustang.CashSplit.service;

import com.mustang.CashSplit.dto.GroupDto;
import com.mustang.CashSplit.model.Group;
import com.mustang.CashSplit.repository.GroupRepository;
import com.mustang.CashSplit.repository.UserExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public Mono<GroupDto> createGroup(Group group) {
        return this.groupRepository.save(group)
                .map(savedEntity -> new GroupDto(savedEntity.getGroupId(), savedEntity.getGroupName(),
                        savedEntity.getDescription(),
                        savedEntity.getGroupType().toString(),
                        savedEntity.isActive()));
    }


}
