<template>
<div class="goodDetails">
  <a-steps :current="2">
    <a-step>
      <span slot="title">已出单</span>
      <span slot="description">订单信息</span>
    </a-step>
    <a-step title="In Progress" sub-title="Left 00:00:08" description="This is a description." />
    <a-step title="Waiting" description="This is a description." />
    <a-step title="hhh" description="hhh"/>
  </a-steps>
  <a-card :title="goodsId" style="height: 800px">
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
    goodsId:null
  }
  },
  mounted() {
    this.getId();
  },
  methods:{
    getId(){
      this.goodsId = this.$route.params["goodsId"];
    },
  }
}
</script>

<style scoped>

</style>
