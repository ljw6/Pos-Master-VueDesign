package snnu.campusmarket.market.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snnu.campusmarket.market.Dao.GoodsDao;
import snnu.campusmarket.market.Entity.Goods;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;

    public List<Goods> getGoodListWithWrapper(String map, int name){
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.eq(map,name);
        List<Goods> list = goodsDao.selectList(wrapper);
        return list;
    }

    public void saveNewGoods(Goods goods){
        goodsDao.insert(goods);
    }
}
