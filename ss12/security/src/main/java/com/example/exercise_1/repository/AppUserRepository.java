package com.example.exercise_1.repository;

import com.example.exercise_1.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    AppUser findAppUserByUserName(String userName);
    @Query(value = " select role_name as roleName\n" +
            "from app_role ar\n" +
            "join user_role ur on ar.app_role_id = ur.app_role_id\n" +
            "join app_user au on au.app_user_id = ur.app_user_id\n" +
            "where au.app_user_id = :userId ",nativeQuery = true)
    List<String> getRoleNames(@Param("userId") Long userId);
}
