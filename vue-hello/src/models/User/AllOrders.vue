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
          <a-list-item slot="renderItem" key="item.title" slot-scope="item" id="1">
            <a slot="title" href="/">{{item.goodsName}}</a>
            <a-row type="flex" justify="start">
              <a-col :xs="6" :lg="4">
                <router-link to="/details/123">
                  <img :src="item.img" style="height: 150px; width: 150px" />
                </router-link>
              </a-col>
              <a-col :xs="6" :lg="6">
                <div class="goodsDetails">
                  <span>商品：{{item.goodsName}}</span>
                  <br />
                  <span>价格：{{item.price}}￥</span>
                  <br />
                  <span>交易时间：{{item.saleDate}}</span>
                </div>
              </a-col>
            </a-row>
            <span slot="extra" style="margin-top: 20px;display: flex;align-items: center;">
              <router-link to="/details/456">详细信息</router-link></span>
          </a-list-item>
        </a-list>
      </div>
      <div v-else-if="orderKey === 'waitForPay'">
        <a-list
            class="demo-loadmore-list"
            item-layout="vertical"
            size="large"
            :pagination="pagination"
            :data-source="datalist"
        >
          <a-list-item slot="renderItem" key="item.title" slot-scope="item" id="2">
            <a slot="title" href="/">{{item.goodsName}}</a>
            <a-row type="flex" justify="start">
              <a-col :xs="6" :lg="4">
                <router-link to="/details/123">
                  <img :src="item.img" style="height: 150px; width: 150px" />
                </router-link>
              </a-col>
              <a-col :xs="6" :lg="6">
                <div class="goodsDetails">
                  <span>商品：{{item.goodsName}}</span>
                  <br />
                  <span>价格：{{item.price}}￥</span>
                  <br />
                  <span>交易时间：{{item.saleDate}}</span>
                </div>
              </a-col>
            </a-row>
            <span slot="extra" style="margin-top: 20px;display: flex;align-items: center;"
            ><router-link to="/details/456">详细信息</router-link></span
            >
          </a-list-item>
        </a-list>
      </div>
      <div v-else-if="orderKey === 'waitForSend'">
        <a-list
            class="demo-loadmore-list"
            item-layout="vertical"
            size="large"
            :pagination="pagination"
            :data-source="datalist"
        >
          <a-list-item slot="renderItem" key="item.title" slot-scope="item" id="3">
            <a slot="title" href="/">{{item.goodsName}}</a>
            <a-row type="flex" justify="start">
              <a-col :xs="6" :lg="4">
                <router-link to="/details/123">
                  <img :src="item.img" style="height: 150px; width: 150px" />
                </router-link>
              </a-col>
              <a-col :xs="6" :lg="6">
                <div class="goodsDetails">
                  <span>商品：{{item.goodsName}}</span>
                  <br />
                  <span>价格：{{item.price}}￥</span>
                  <br />
                  <span>交易时间：{{item.saleDate}}</span>
                </div>
              </a-col>
            </a-row>
            <span slot="extra" style="margin-top: 20px;display: flex;align-items: center;"
            ><router-link to="/details/456">详细信息</router-link></span
            >
          </a-list-item>
        </a-list>
      </div>
      <div v-else-if="orderKey === 'waitForComment'">
        <a-list
          class="demo-loadmore-list"
          item-layout="vertical"
          size="large"
          :pagination="pagination"
          :data-source="datalist"
      >
        <a-list-item slot="renderItem" key="item.title" slot-scope="item" id="4">
          <a slot="title" href="/">{{item.goodsName}}</a>
          <a-row type="flex" justify="start">
            <a-col :xs="6" :lg="4">
              <router-link to="/details/123">
                <img :src="item.img" style="height: 150px; width: 150px" />
              </router-link>
            </a-col>
            <a-col :xs="6" :lg="6">
              <div class="goodsDetails">
                <span>商品：{{item.goodsName}}</span>
                <br />
                <span>价格：{{item.price}}￥</span>
                <br />
                <span>交易时间：{{item.saleDate}}</span>
              </div>
            </a-col>
          </a-row>
          <span slot="extra" style="margin-top: 20px;display: flex;align-items: center;"
          ><router-link to="/details/456">详细信息</router-link></span
          >
        </a-list-item>
      </a-list>
      </div>
      <div v-else-if="orderKey === 'waitForAck'">
        <a-list
            class="demo-loadmore-list"
            item-layout="vertical"
            size="large"
            :pagination="pagination"
            :data-source="datalist"
        >
          <a-list-item slot="renderItem" key="item.title" slot-scope="item" id="5">
            <a slot="title" href="/">{{item.goodsName}}</a>
            <a-row type="flex" justify="start">
              <a-col :xs="6" :lg="4">
                <router-link to="/details/123">
                  <img :src="item.img" style="height: 150px; width: 150px" />
                </router-link>
              </a-col>
              <a-col :xs="6" :lg="6">
                <div class="goodsDetails">
                  <span>商品：{{item.goodsName}}</span>
                  <br />
                  <span>价格：{{item.price}}￥</span>
                  <br />
                  <span>交易时间：{{item.saleDate}}</span>
                </div>
              </a-col>
            </a-row>
            <span slot="extra" style="margin-top: 20px;display: flex;align-items: center;"
            ><router-link to="/details/456">详细信息</router-link></span
            >
          </a-list-item>
        </a-list>
      </div>
    </a-card>
  </div>
</template>

<script>
export default {
  name: "AllOrders",
  mounted() {
    this.getTab();
    this.getGoodsList();
  },
  data(){
    return{
      datalist: [],
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
          key: 'waitForSend',
          tab: '待发货',
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
      userId: null,
    }
  },
  methods:{
    onTabChange(key,type) {
      this[type] = key;
      this.datalist=[];
      if (key === "all"){
        this.getGoodsList()
      }
      else {
        this.getGoodsListByKey(key)
      }
    },
    getTab(){
      let key = this.$route.params['Tab'];
      if (key == null){
        return null;
      }
      else {
        this.orderKey = key;
      }
    },
    getGoodsList(){
      this.getUser().then(res=>{
        this.$http.get("/getGoodsByerId/"+res)
            .then(
                res=>{
                  let data = res.data
                  data.forEach((item)=>{
                    this.datalist.push(
                        {
                          goodsName: item.name,
                          price: item.price,
                          saleDate: item.byTime,
                        }
                    )
                  })
                }
            );
      })
    },
    getGoodsListByKey(key){
      this.getUser().then(res=>{
            this.$http.get("/getGoodsByerId/"+res+"/"+key)
                .then(
                    res=>{
                      let data = res.data
                      data.forEach((item)=>{
                        this.datalist.push(
                            {
                              goodsName: item.name,
                              price: item.price,
                              saleDate: item.byTime,
                            }
                        )
                      })
                    }
                );
          }
      )
    },
    async getUser(){
      let id = null;
      await this.$http.get("/token").then(
          res =>{
            id = res.data.id;
          }
      ).catch(
          err =>{
            console.log(err);
          }
      )
      return id;
    }
  }
}
</script>

<style scoped>
/*#operations{*/
/*  display: flex;*/
/*  align-items: center;*/
/*}*/
.goodsDetails{
  width: 460px;
  margin-left: 20px;
  margin-top: 22px;
}
#items .ant-list-item-main{
  display: flex;
}
</style>
