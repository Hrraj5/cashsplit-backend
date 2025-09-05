package com.mustang.CashSplit.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Table("cs_user_expense")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserExpense {
    @Id
    private UUID id;

    @Column("group_id")
    private String groupId;

    @Column("paid_by")
    private String paidBy;

    @Column("paid_to")
    private String paidTo;

    @Column("amount")
    private String amount;

    @Column("amount_in_numeric")
    private BigDecimal amountInDouble;

    @Column("created_at")
    private Instant createdAt;

    @Column("updated_at")
    private Instant updatedAt;
}
