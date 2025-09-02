package com.mustang.CashSplit.service;

import com.mustang.CashSplit.model.User;
import com.mustang.CashSplit.model.UserGroup;
import com.mustang.CashSplit.repository.UserGroupRepository;
import com.mustang.CashSplit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserGroupRepository userGroupRepository;

    public Mono<Void> createUser(User user){
        return this.userRepository.save(user).then();
    }

    public Mono<Void> addUserToGrop(UserGroup userGroup){
        return this.userGroupRepository.save(userGroup).then();
    }
}
