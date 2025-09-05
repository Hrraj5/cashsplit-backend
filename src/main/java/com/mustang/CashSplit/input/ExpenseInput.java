package com.mustang.CashSplit.input;

import java.util.List;

public record ExpenseInput(String groupId, String description, String totalAmount, String paidBy, String category, List<String> userIds) {
}
