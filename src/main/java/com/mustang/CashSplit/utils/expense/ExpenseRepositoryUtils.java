package com.mustang.CashSplit.utils.expense;

import com.mustang.CashSplit.input.ExpenseInput;
import com.mustang.CashSplit.model.parameter.BulkUpdateUsersParameter;

import java.math.BigDecimal;
import java.util.Map;

public class ExpenseRepositoryUtils {

    public static BulkUpdateUsersParameter computeParametersForBulkUpdateUsers(int numberOfUsers, Map<String,BigDecimal> signedAmountMap, ExpenseInput expenseInput){
        String[] ids = new String[numberOfUsers];
        String[] balance = new String[numberOfUsers];
        BigDecimal[] balanceInDouble = new BigDecimal[numberOfUsers];
        for(int i=0;i< signedAmountMap.size();i++){
            ids[i] = expenseInput.userIds().get(i);
            balance[i] = signedAmountMap.get(ids[i]).toString();
            balanceInDouble[i] = signedAmountMap.get(ids[i]);
        }
        return new BulkUpdateUsersParameter(ids,balance,balanceInDouble);
    }
}
