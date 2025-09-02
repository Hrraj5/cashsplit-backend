package com.mustang.CashSplit.repository;

import com.mustang.CashSplit.model.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends R2dbcRepository<User,String> {
    @Override
    <S extends User> Mono<S> save(S entity);
}
