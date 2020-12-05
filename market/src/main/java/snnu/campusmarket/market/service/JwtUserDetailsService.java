package snnu.campusmarket.market.service;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import snnu.campusmarket.market.Dao.UserDao;
import snnu.campusmarket.market.Entity.Users;

import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");//配置权限角色
    @Override
    public UserDetails loadUserByUsername(String username) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Users user = userDao.selectOne(wrapper);

        String pass = new BCryptPasswordEncoder().encode(user.getPassword());
        if (user !=null) {
            return new User(user.getUsername(),pass,auth);
        } else {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
    }
}
