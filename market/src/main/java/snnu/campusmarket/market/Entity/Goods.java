package snnu.campusmarket.market.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.lang.Long;

import java.sql.Blob;

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

    public Goods(Long id, String name, String description, BigDecimal price, String area, String catergery, String pushId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.area = area;
        this.catergery = catergery;
        this.pushId = pushId;
    }

    public Goods(Long id, String name, BigDecimal price, String area, String catergery, String pushId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.area = area;
        this.catergery = catergery;
        this.pushId = pushId;
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
}
