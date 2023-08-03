package com.example.exercise_1.service;

import com.example.exercise_1.model.AppUser;
import com.example.exercise_1.repository.AppUserRepository;
import com.example.exercise_1.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserAppService implements UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // đầu tiên mình query xuống database xem có user  đó không
        AppUser appUser = this.appUserRepository.findAppUserByUserName(userName);

        //Nếu không tìm thấy User thì mình thông báo lỗi
        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        // Khi đã có user rồi thì mình query xem user đó có những quyền gì (Admin hay User)
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.appUserRepository.getRoleNames(appUser.getUserId());

        // Dựa vào list quyền trả về mình tạo đối tượng GrantedAuthority  của spring cho quyền đó
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                grantList.add(new SimpleGrantedAuthority(role));
            }
        }

        //Cuối cùng mình tạo đối tượng UserDetails của Spring và mình cung cấp các thông số như tên , password và quyền
        // Đối tượng userDetails sẽ chứa đựng các thông tin cần thiết về user từ đó giúp Spring Security quản lý
        // được phân quyền như ta đã cấu hình trong bước 4 method configure
        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(),
                appUser.getPassword(), grantList);

        return userDetails;
    }


}
