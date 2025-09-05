package com.mustang.CashSplit.model.parameter;

import java.math.BigDecimal;

public record BulkUpdateUsersParameter(String[] ids, String[] balance, BigDecimal[] balanceInDouble) {
}
