package com.mustang.CashSplit.model;

import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("cs_user_group")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserGroup implements Persistable<UserGroupId> {
    private String userId;
    private String groupId;

    @Transient
    private boolean isNew = false;

    @Override
    public UserGroupId getId() {
        return new UserGroupId(userId,groupId);
    }

    @Override
    public boolean isNew() {
        return isNew || (userId == null || groupId == null);
    }
}
