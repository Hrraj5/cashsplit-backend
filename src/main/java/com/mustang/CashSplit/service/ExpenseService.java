package com.mustang.CashSplit.service;

import com.mustang.CashSplit.input.ExpenseInput;
import com.mustang.CashSplit.model.Expense;
import com.mustang.CashSplit.model.parameter.BulkUpdateUsersParameter;
import com.mustang.CashSplit.repository.ExpenseRepository;
import com.mustang.CashSplit.repository.UserGroupRepository;
import com.mustang.CashSplit.utils.common.MathUtils;
import com.mustang.CashSplit.utils.expense.ExpenseRepositoryUtils;
import com.mustang.CashSplit.utils.expense.ExpenseUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserGroupRepository userGroupRepository;

    public Mono<Void> createExpense(Expense expense, ExpenseInput expenseInput){
        int numberOfUsers = expenseInput.userIds().size();
        BigDecimal splitAmount = MathUtils.getSplitAmount(expense.getTotalAmountInDouble(),numberOfUsers);
        Map<String,BigDecimal> signedAmountMap =  ExpenseUtils.computeSplitAmountToBePositiveAndNegative(expenseInput.userIds(),expense.getPaidBy(),splitAmount);
        BulkUpdateUsersParameter bulkUpdateUsersParameter = ExpenseRepositoryUtils.computeParametersForBulkUpdateUsers(numberOfUsers,signedAmountMap,expenseInput);

        return this.userGroupRepository.bulkUpdateBalanceOfUserGroup(bulkUpdateUsersParameter.ids(),bulkUpdateUsersParameter.balance(),bulkUpdateUsersParameter.balanceInDouble(),expense.getGroupId())
                .flatMap(success -> {
                    if(success==1)
                        return this.expenseRepository.save(expense);
                    else return Mono.error(new Error("Issue occurred while updating the balance of the users."));
                })
                .then();
    }
}
