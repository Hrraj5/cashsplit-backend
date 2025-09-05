package com.mustang.CashSplit.utils.expense;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ExpenseUtils {

    public static Map<String,BigDecimal> computeSplitAmountToBePositiveAndNegative(List<String> userIds, String paidBy, BigDecimal splitAmount){
        Map<String,BigDecimal> signedAmountMap = new HashMap<>();
        for(String userId : userIds){
            if(Objects.nonNull(paidBy) && Objects.equals(paidBy,userId)){
                signedAmountMap.put(userId,splitAmount);
            }else{
                signedAmountMap.put(userId,new BigDecimal("-"+ splitAmount.toString()));
            }
        }
        return signedAmountMap;
    }
}
