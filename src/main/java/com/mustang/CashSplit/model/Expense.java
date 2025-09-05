package com.mustang.CashSplit.model;

import com.mustang.CashSplit.model.enums.ExpenseCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Table("cs_expense")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Expense implements Persistable<String> {
    @Id
    @Column("id")
    private String id;

    @Column("group_id")
    private String groupId;

    @Column("description")
    private String description;

    @Column("total_amount")
    private String totalAmount;

    @Column("total_amount_in_double")
    private BigDecimal totalAmountInDouble;

    @Column("paid_by")
    private String paidBy;

    @Column("category")
    private ExpenseCategory category;

    @Column("created_at")
    private Instant createdAt;

    @Column("updated_at")
    private Instant updatedAt;

    @Transient
    private boolean isNew;

    @Override
    public boolean isNew() {
        return isNew || id == null;
    }
}
