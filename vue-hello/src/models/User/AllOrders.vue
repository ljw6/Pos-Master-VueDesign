<template>
  <div class="orders">
    <a-list
        class="demo-loadmore-list"
        item-layout="vertical" size="large" :pagination="pagination"
        :data-source="datalist"
    >
    <a-list-item slot="renderItem" key="item.title" slot-scope="item">
      <router-link to="/details/123">
      <img :src="item.img" style="height: 150px;width: 150px">
      <div class="goodsDetails">
      <span>{{item.goodsName}}</span>
      <br>
      <span>{{item.price}}</span>
      <br>
      <span>{{item.saleDate}}</span>
      </div>
      </router-link>
    </a-list-item>
    </a-list>
  </div>
</template>

<script>
const datalist=[];
for (let i=0;i<10;i++){
  datalist.push({
    title: `ant design vue part ${i}`,
    img: "https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png",
    goodsName: '商品名',
    price: '价格',
    saleDate: '购买时间'
  });
}
export default {
  name: "AllOrders",
  data(){
    return{
      datalist,
      pagination: {
        onChange: page => {
          console.log(page);
        },
        pageSize: 3,
      },
    }
  }
}
</script>

<style scoped>

</style>
