package com.mustang.CashSplit.repository;

import com.mustang.CashSplit.model.UserGroup;
import com.mustang.CashSplit.model.UserGroupId;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Repository
public interface UserGroupRepository extends R2dbcRepository<UserGroup, UserGroupId> {

    @Override
    <S extends UserGroup> Mono<S> save(S entity);

    @Modifying
    @Query("""
    UPDATE cs_user_group 
    SET balance = data.balance,
        balance_in_double = data.balanceInDouble
    FROM (
        SELECT UNNEST(:ids::text[]) as id,
               UNNEST(:balance::text[]) as balance,
               UNNEST(:balanceInDouble::numeric[]) as balanceInDouble
    ) AS data 
    WHERE cs_user_group.user_id = data.id AND cs_user_group.group_id = :groupId
    """)
    Mono<Integer> bulkUpdateBalanceOfUserGroup(@Param("ids") String[] ids,
                                               @Param("balance") String[] balance,
                                               @Param("balanceInDouble") BigDecimal[] balanceInDouble,
                                               @Param("groupId") String groupId);
}
