package snnu.campusmarket.market.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.lang.Long;

@TableName("goods")
public class Goods {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String area;
    private String catergery;
    private String pushId;
    private String pushTime;
    private String byId;
    private String saleState;

    /*
    用于接受前端传递的对象
     */

    public Goods() {
    }

    public Goods(Long id, String name, String description, BigDecimal price, String area, String catergery, String pushId, String pushTime,String saleState) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.area = area;
        this.catergery = catergery;
        this.pushId = pushId;
        this.pushTime = pushTime;
        this.saleState = saleState;
    }

    public Goods(Long id, String name, BigDecimal price, String area, String catergery, String pushId, String pushTime,String saleState) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.area = area;
        this.catergery = catergery;
        this.pushId = pushId;
        this.pushTime = pushTime;
        this.saleState = saleState;
    }


    public Goods(Long id, String name, String description, BigDecimal price, String area, String catergery, String pushId, String pushTime, String byId, String saleState) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.area = area;
        this.catergery = catergery;
        this.pushId = pushId;
        this.pushTime = pushTime;
        this.byId = byId;
        this.saleState = saleState;
    }

    public Goods(Long id, String name, BigDecimal price, String area, String catergery, String pushId, String pushTime, String byId, String saleState) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.area = area;
        this.catergery = catergery;
        this.pushId = pushId;
        this.pushTime = pushTime;
        this.byId = byId;
        this.saleState = saleState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCatergery() {
        return catergery;
    }

    public void setCatergery(String catergery) {
        this.catergery = catergery;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getPushTime() {
        return pushTime;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime;
    }

    public String getById() {
        return byId;
    }

    public void setById(String byId) {
        this.byId = byId;
    }

    public String getSaleState() {
        return saleState;
    }

    public void setSaleState(String saleState) {
        this.saleState = saleState;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", area='" + area + '\'' +
                ", catergery='" + catergery + '\'' +
                ", pushId='" + pushId + '\'' +
                ", pushTime='" + pushTime + '\'' +
                ", byId='" + byId + '\'' +
                ", saleState='" + saleState + '\'' +
                '}';
    }
}
