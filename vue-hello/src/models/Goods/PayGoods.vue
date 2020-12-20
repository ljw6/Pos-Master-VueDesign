<template>
<div class="pay">
    <a-descriptions bordered>
      <a-descriptions-item label="商品名">
        {{Goods.name}}
      </a-descriptions-item>
      <a-descriptions-item label="发布园区">
        {{Goods.area}}
      </a-descriptions-item>
      <a-descriptions-item label="商品分类">
        {{Goods.catergery}}
      </a-descriptions-item>
      <a-descriptions-item label="发布时间" :span="2">
        {{Goods.pushTime}}
      </a-descriptions-item>
      <a-descriptions-item label="商品定价">
        {{Goods.price}}
      </a-descriptions-item>
    </a-descriptions>
    <div class="oper" style="margin-top: 100px;text-align: center">
      <a-button @click="pay"> 付款 </a-button>
      <a-button> 取消 </a-button>
    </div>
  <a-modal
    title="确认付款"
    :visible="visible"
    :confirm-loading="confirmLoading"
    @ok = "HandleOk"
    @cancel="cancelPay"
    style="text-align: center"
  >
    <p style="font-size: 18px">{{Goods.price}}</p>
    <p style="font-size: 16px">确定要支付吗？</p>
  </a-modal>
</div>
</template>

<script>

let Goods = null;
export default {
  beforeCreate() {
    Goods = this.$route.params.Goods;
  },
  mounted() {
    this.getByUser();
    },
  name: "PayGoods",
  data(){
    return{
      Goods,
      byId: null,
      visible:false,
      confirmLoading: false,
    }
  },
  methods:{
    pay(){
        this.visible = true;
    },
    HandleOk(){
      this.confirmLoading = true;
      this.$http.put("/updateState",{
        id:this.Goods.id,
        "byId": this.byId,
        saleState:"waitForSend"
      }).then(
          res =>{
            console.log(res)
            this.visible = false;
            this.confirmLoading = false;
          }
      ).catch(
          err =>{
            console.log(err)
          }
      )
    },
    cancelPay(){
      this.$http.put("/updateState",{
        "id":this.Goods.id,
        "byId": this.byId,
        "saleState":"waitForPay"
      }).then(
          res =>{
            console.log(res)
            this.visible = false;
          }
      ).catch(
          err =>{
            console.log(err)
          }
      );
      alert("我们将为您保存订单24小时");
    },
    getByUser(){
      this.$http.get("/token").then(
          res =>{
            this.byId = res.data.id;
          }
      ).catch(
          err =>{
            console.log(err)
          }
      )
    }
  }
}
</script>

<style scoped>

</style>
