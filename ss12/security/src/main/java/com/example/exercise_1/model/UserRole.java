package com.example.exercise_1.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "app_user_id",referencedColumnName = "app_user_id")
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(name = "app_role_id",referencedColumnName = "app_role_id")
    private AppRole appRole;

    public UserRole() {
    }

    public UserRole(Long id, AppUser appUser, AppRole appRole) {
        this.id = id;
        this.appUser = appUser;
        this.appRole = appRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}
