package com.example.exercise_1.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "app_role")
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_role_id")
    private Long id;
    @Column(name = "role_name")
    private String roleNam;
    @OneToMany(mappedBy = "appRole")
    private Set<UserRole> userRoleSet;
    public AppRole() {
    }
    public AppRole(Long id, String roleNam, Set<UserRole> userRoles) {
        this.id = id;
        this.roleNam = roleNam;
        this.userRoleSet = userRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleNam() {
        return roleNam;
    }

    public void setRoleNam(String roleNam) {
        this.roleNam = roleNam;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoles) {
        this.userRoleSet = userRoles;
    }
}
