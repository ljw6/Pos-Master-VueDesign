package snnu.campusmarket.market.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import snnu.campusmarket.market.Dao.UserDao;
import snnu.campusmarket.market.Entity.Users;

import java.util.List;

/*
使用Dao 认证
 */
@Service("userLoginService")
public class UserLoginService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Users user = userDao.selectOne(wrapper);
        if (user==null){
            throw new UsernameNotFoundException("not found");
        }
        else {
            return new User(user.getUsername(),passwordEncoder().encode(user.getPassword()),auth);
        }
    }
}
