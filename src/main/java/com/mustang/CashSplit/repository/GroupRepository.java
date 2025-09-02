package com.mustang.CashSplit.repository;

import com.mustang.CashSplit.model.Group;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface GroupRepository extends R2dbcRepository<Group,String> {
    @Override
    <S extends Group> Mono<S> save(S entity);
}
