package com.mustang.CashSplit.utils.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtils {

    public static BigDecimal getSplitAmount(BigDecimal amount, int numberOfUsers){
        return amount.divide(BigDecimal.valueOf(numberOfUsers), 2, RoundingMode.HALF_UP);
    }
}
