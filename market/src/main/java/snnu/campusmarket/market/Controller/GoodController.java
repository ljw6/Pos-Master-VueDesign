package snnu.campusmarket.market.Controller;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snnu.campusmarket.market.Entity.Goods;
import snnu.campusmarket.market.service.GoodsService;
import snnu.campusmarket.market.service.UserService;

import java.util.List;

@RestController
@CrossOrigin
public class GoodController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    UserService userService;

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
    public void updateState(@RequestBody Goods goods){
        System.out.println("goods=>"+goods);
        goodsService.updateGoodsSaleState(goods);
    }

    @GetMapping("/getGoodsById/{id}")
    public Goods getGoodsById(@PathVariable Long id){
        return goodsService.getGoodsById(id);
    }

    @GetMapping("/getUserById/{id}")
    public String getUserById(@PathVariable String id){
        return userService.getUserNameById(id);
    }

    @GetMapping("/getGoodsByerId/{id}")
    public List<Goods> getGoodsByById(@PathVariable String id){
        System.out.println(goodsService.getGoodsByById(id));
        return goodsService.getGoodsByById(id);
    }

    @GetMapping("/getGoodsByerId/{id}/{state}")
    public List<Goods> getGoodsListByState(@PathVariable String id,@PathVariable String state){
        System.out.println(goodsService.getGoodsByState(id,state));
        return goodsService.getGoodsByState(id,state);
    }
}
