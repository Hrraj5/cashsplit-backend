package com.mustang.CashSplit.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserExpenseRepository {

    private final DatabaseClient databaseClient;


    public Mono<Void> initializeUserExpenses(String groupId, String newUserId) {
        String sql = """
    INSERT INTO cs_user_expense (group_id, paid_by, paid_to, amount)
    SELECT $1, $2, ug.user_id, 0
    FROM cs_user_group ug
    WHERE ug.group_id = $1 AND ug.user_id <> $2

    UNION ALL

    SELECT $1, ug.user_id, $2, 0
    FROM cs_user_group ug
    WHERE ug.group_id = $1 AND ug.user_id <> $2
    """;

        return databaseClient.sql(sql)
                .bind(0, groupId)   // $1
                .bind(1, newUserId) // $2
                .fetch()
                .rowsUpdated()
                .then();
    }
}
