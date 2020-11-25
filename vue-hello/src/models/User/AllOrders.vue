<template>
  <div class="orders">
    <a-card
        style="width: 100%"
        title="我的订单"
        :tab-list="tabList"
        :active-tab-key="orderKey"
        @tabChange="key=>onTabChange(key,'orderKey')"
    >
      <div v-if="orderKey === 'all'">
        <a-list
            class="demo-loadmore-list"
            item-layout="vertical"
            size="large"
            :pagination="pagination"
            :data-source="datalist"
        >
          <a-list-item slot="renderItem" key="item.title" slot-scope="item" id="items">
            <a slot="title" href="/">{{item.goodsName}}</a>
            <a-row type="flex" justify="start">
              <a-col :xs="6" :lg="4">
                <router-link to="/details/123">
                  <img :src="item.img" style="height: 150px; width: 150px" />
                </router-link>
              </a-col>
              <a-col :xs="6" :lg="6">
                <div class="goodsDetails">
                  <span>{{item.goodsName}}</span>
                  <br />
                  <span>{{item.price}}</span>
                  <br />
                  <span>{{item.saleDate}}</span>
                </div>
              </a-col>
            </a-row>
            <span slot="extra" style="margin-top: 20px" id="operations"
            ><router-link to="/details/456">详细信息</router-link></span
            >
          </a-list-item>
        </a-list>
      </div>
      <div v-else-if="orderKey === 'waitForPay'">
        <span>待付款</span>
      </div>
      <div v-else-if="orderKey === 'waitForRecv'">
        <span>待收货</span>
      </div>
      <div v-else-if="orderKey === 'waitForComment'">
        <span>待评价</span>
      </div>
      <div v-else-if="orderKey === 'waitForAck'">
        <span>待确认</span>
      </div>
    </a-card>
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
  mounted() {
    this.getTab();
  },
  data(){
    return{
      datalist,
      pagination: {
        onChange: page => {
          console.log(page);
        },
        pageSize: 3,
      },
      tabList:[
        {
          key: 'all',
          tab: '全部订单',
        },
        {
          key: 'waitForPay',
          tab: '待付款',
        },
        {
          key: 'waitForRecv',
          tab: '待收货',
        },
        {
          key: 'waitForAck',
          tab: '待确认'
        },
        {
          key: 'waitForComment',
          tab: '待评价'
        }
      ],
      orderKey: 'all',
    }
  },
  methods:{
    onTabChange(key, type) {
      console.log(key, type);
      this[type] = key;
    },
    getTab(){
      let key = this.$route.params['Tab'];
      if (key == null){
        return null;
      }
      else {
        this.orderKey = key;
      }
    }
  }
}
</script>

<style scoped>
#operations{
  display: flex;
  align-items: center;
}
.goodsDetails{
  width: 60px;
  margin-left: 20px;
}
#items .ant-list-item-main{
  display: flex;
}
</style>
