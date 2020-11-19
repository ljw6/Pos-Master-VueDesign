package snnu.campusmarket.market.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import snnu.campusmarket.market.Entity.Users;

@Repository
public interface UserDao extends BaseMapper<Users> {
}
