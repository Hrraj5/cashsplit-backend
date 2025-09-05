package com.mustang.CashSplit.controller;

import com.mustang.CashSplit.input.ExpenseInput;
import com.mustang.CashSplit.model.Expense;
import com.mustang.CashSplit.model.enums.ExpenseCategory;
import com.mustang.CashSplit.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @MutationMapping
    public Mono<ResponseEntity<Void>> createExpense(@Argument("input")ExpenseInput expenseInput){
        Expense expense = Expense.builder()
                .id(UUID.randomUUID().toString())
                .groupId(expenseInput.groupId())
                .description(expenseInput.description())
                .totalAmount(expenseInput.totalAmount())
                .totalAmountInDouble(new BigDecimal(expenseInput.totalAmount()))
                .paidBy(expenseInput.paidBy())
                .category(ExpenseCategory.valueOf(expenseInput.category()))
                .isNew(true)
                .build();
        return this.expenseService.createExpense(expense, expenseInput)
                .then(Mono.just(new ResponseEntity<>(HttpStatus.CREATED)));
    }
}
