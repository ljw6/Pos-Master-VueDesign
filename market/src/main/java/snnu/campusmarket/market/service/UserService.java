package snnu.campusmarket.market.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import snnu.campusmarket.market.Dao.UserDao;
import snnu.campusmarket.market.Entity.Users;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public Users getUserFromUserDetails(User user){
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        Users users = userDao.selectOne(wrapper);
        return users;
    }

    public String getUserNameById(String id){
        Users user = userDao.selectById(id);
        return user.getUsername();
    }
}
