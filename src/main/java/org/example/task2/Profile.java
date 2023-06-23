package org.example.task2;

import java.util.Objects;

public class Profile {
    public Long id;
    public Long orgId;
    public Long groupId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Profile(Long id, Long orgId, Long groupId) {
        this.id = id;
        this.orgId = orgId;
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id) && Objects.equals(orgId, profile.orgId) && Objects.equals(groupId, profile.groupId);
    }

}
