package com.mustang.CashSplit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroupId {
    private String userId;
    private String groupId;

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass()!=obj.getClass()) return false;
        UserGroupId that = (UserGroupId) obj;
        return Objects.equals(groupId,that.groupId) && Objects.equals(userId,that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId,groupId);
    }
}
