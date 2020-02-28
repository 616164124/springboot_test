package com.example.demo.generator;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Entity;

/**
 * t_user_role
 * @author 
 */
@Data
public class TUserRole implements Serializable {
    /**
     * 用户ID
     */
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 角色ID
     */
    private Long roleId;

    private static final long serialVersionUID = 1L;
}