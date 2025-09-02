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

@Builder
@Getter
@Table("cs_group")
@NoArgsConstructor
@AllArgsConstructor
public class Group implements Persistable<String> {
    @Id
    @Column("id")
    private String groupId;
    @Column("group_name")
    private String groupName;
    @Column("description")
    private String description;
    @Column("is_active")
    private boolean active;
    @Column("created_at")
    private Instant createdAt;
    @Column("updated_at")
    private Instant updatedAt;

    @Transient
    private boolean isNew;

    @Override
    public String getId() {
        return groupId;
    }

    @Override
    public boolean isNew() {
        return isNew || groupId == null;
    }


}
