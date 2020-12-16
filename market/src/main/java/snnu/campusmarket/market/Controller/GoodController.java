package snnu.campusmarket.market.Controller;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
}
