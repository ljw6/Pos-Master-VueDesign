package snnu.campusmarket.market.Controller;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snnu.campusmarket.market.Entity.Goods;
import snnu.campusmarket.market.service.GoodsService;

@RestController
@CrossOrigin
public class GoodController {

    @Autowired
    GoodsService goodsService;

    @PostMapping("/saveNew")
    public Boolean saveNewGoods(Goods goods){
        goods.setPushTime(DateUtil.now());
        if (goods != null){
            goodsService.saveNewGoods(goods);
            return true;
        }
        else {
            System.out.println("fail to save");
            return false;
        }
    }

    @PutMapping("/updateState")
    public void updateState(Goods goods){
        goodsService.updateGoodsSaleState(goods);
    }
}
