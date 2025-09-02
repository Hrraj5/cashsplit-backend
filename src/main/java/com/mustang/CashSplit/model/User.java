package com.mustang.CashSplit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("cs_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User implements Persistable<String> {
    @Id
    @Column("id")
    private String userId;
    @Column("username")
    private String userName;
    @Column("name")
    private String name;
    @Column("phone_number")
    private String phoneNumber;
    @Column("created_at")
    private Instant createdAt;
    @Column("updated_at")
    private Instant updatedAt;

    @Transient
    private boolean isNew;

    @Override
    public String getId() {
        return userId;
    }

    @Override
    public boolean isNew() {
        return isNew || userId == null;
    }

}
