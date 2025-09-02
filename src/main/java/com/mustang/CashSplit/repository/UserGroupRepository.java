package com.mustang.CashSplit.repository;

import com.mustang.CashSplit.model.UserGroup;
import com.mustang.CashSplit.model.UserGroupId;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserGroupRepository extends R2dbcRepository<UserGroup, UserGroupId> {
    @Override
    <S extends UserGroup> Mono<S> save(S entity);
}
