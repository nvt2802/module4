package com.example.exercise_1.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "appUser")
    private Set<UserRole> userRoleSet;

    public AppUser() {
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }

    public AppUser(Long userId, String userName, String password, Set<UserRole> userRoleSet) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userRoleSet = userRoleSet;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
