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

    public void updateGoodsSaleState(Goods goods){
        goodsDao.updateById(goods);
    }

    public Goods getGoodsById(Long id){
        return goodsDao.selectById(id);
    }

    public List<Goods> getGoodsByById(String id){
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.eq("by_id",id);
        List<Goods> list = goodsDao.selectList(wrapper);
        return list;
    }

    public List<Goods> getGoodsByState(String id,String state){
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.eq("by_id",id);
        wrapper.eq("sale_state",state);
        List<Goods> list = goodsDao.selectList(wrapper);
        return list;
    }

    public List<Goods> getGoodsByPusher(String id){
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.eq("push_id",id);
        List<Goods> list = goodsDao.selectList(wrapper);
        return list;
    }

    public void delGoodsById(Long id){
        goodsDao.deleteById(id);
    }
}
