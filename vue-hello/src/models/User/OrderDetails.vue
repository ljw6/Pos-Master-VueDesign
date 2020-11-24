<template>
<div class="goodDetails">
  <a-card :title="goodsid" style="height: 800px">
    <a-card-grid style="width: 100%;text-align: left">
      goodsName
    </a-card-grid>
    <a-card-grid style="width: 100%;">
      goodsDetail
    </a-card-grid>
    <a-card-grid style="width: 100%;">
      operations
    </a-card-grid>
  </a-card>
</div>
</template>

<script>
export default {
name: "OrderDetails",
  data(){
  return{
    goodsid:null
  }
  },
  mounted() {
    this.getId();
  },
  methods:{
    getId(){
      this.goodsid = this.$route.params["goodsId"];
    }
  }
}
</script>

<style scoped>

</style>
