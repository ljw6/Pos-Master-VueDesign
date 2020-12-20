<template>
  <div class="detial">
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
          <a-descriptions-item label="发布者" :span="2">
            {{goodsPusher}}
          </a-descriptions-item>
          <a-descriptions-item label="出售状态" :span="3">
            <a-badge status="processing" text="Running" />
          </a-descriptions-item>
          <a-descriptions-item label="商品定价">
            {{Goods.price}}
          </a-descriptions-item>
          <a-descriptions-item label="商品描述">
            {{Goods.description}}
          </a-descriptions-item>
        </a-descriptions>
      <div class="operations" style="text-align: center">
        <a-button @click="payForGoods"> 购买 </a-button>
        <a-button> 加入购物车 </a-button>
        <a-button @click="backToHome"> 返回首页 </a-button>
      </div>
  </div>
</template>

<script>

export default {
  mounted() {
    this.getGoodsById()
    },
  name: "Goods",
  data(){
  return{
    goodsPusher:null,
    Goods:null
  }
  },
  methods:{
    getGoodsById(){
      this.$http.get("/getGoodsById/"+parseInt(this.getIdFromroute())
      ).then(res=>{
        this.Goods = res.data;
        this.getUserNameById(res.data.pushId);
      })
    },
    getUserNameById(id){
      this.$http.get("/getUserById/"+id)
          .then(res =>{
            this.goodsPusher = res.data
          })
    },
    getIdFromroute(){
      return this.$route.query.id
    },
    backToHome(){
      self.location.href = "/"
    },
    payForGoods(){
      let auth = this.$tokener.getLocalStorage("authorization");
      if (auth){
        this.$router.push({name:"Pay",params:{Goods:this.Goods}})
      }
      else {
        alert("请登录");
        self.location.href = "/login";
      }
    }
  }
}
</script>

<style scoped>

</style>
