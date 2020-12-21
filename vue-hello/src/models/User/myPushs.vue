<template>
  <div class="car">
    <a-list
        class="demo-loadmore-list"
        item-layout="vertical"
        size="large"
        :pagination="pagination"
        :data-source="datalist"
    >
      <a-list-item slot="renderItem" key="item.title" slot-scope="item" id="waitForComment">
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
        <div slot="extra" style="margin-top: 20px;display: flex;align-items: center;" >
        <p @click="delGoods(item.goodsId)">不想卖了</p>
        </div>
      </a-list-item>
    </a-list>
    <div class="dialog">
      <a-modal
          title="确认付款"
          :visible="visible"
          :confirm-loading="confirmLoading"
          @ok = "HandleOk"
          @cancel="cancelDel"
          style="text-align: center"
      >
        <p style="font-size: 16px">确定要下架吗？</p>
      </a-modal>
    </div>
  </div>
</template>

<script>
export default {
  mounted() {
    this.getGoodsList();
  },
  name: "myPushs",
  data(){
  return{
    datalist: [],
    pagination: {
      onChange: page => {
        console.log(page);
      },
      pageSize: 3,
  },
    visible:false,
    confirmLoading: false,
    delId: null,
  }
},
  inject: ['reload'],
  methods:{
    getGoodsList(){
      this.getUser().then(res=>{
        this.$http.get("/getGoodsByPusher/"+res)
            .then(
                res=>{
                  let data = res.data
                  data.forEach((item)=>{
                    this.datalist.push(
                        {
                          goodsName: item.name,
                          price: item.price,
                          saleDate: item.byTime,
                          goodsId: item.id,
                          saleState: item.saleState,
                          goodsDescription: item.description,
                        }
                    )
                  })
                }
            );
      })
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
    },
    delGoods(id){
      console.log(id)
      this.visible = true;
      this.delId = id;
    },
    HandleOk(){
      this.confirmLoading = true;
      this.$http.delete("/delGoodsById/"+this.delId)
      .then(
          res=>{
            console.log(res);
            this.visible = false;
            this.confirmLoading = false;
          }
      );
      this.reload();
    },
    cancelDel(){
      this.visible = false;
      this.reload();
    }
  }
}
</script>

<style scoped>

</style>
