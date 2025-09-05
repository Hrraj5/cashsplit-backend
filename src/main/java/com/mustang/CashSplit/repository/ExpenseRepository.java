package com.mustang.CashSplit.repository;

import com.mustang.CashSplit.model.Expense;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Repository
public interface ExpenseRepository extends R2dbcRepository<Expense,String> {

    @Override
    <S extends Expense> Mono<S> save(S entity);

}
