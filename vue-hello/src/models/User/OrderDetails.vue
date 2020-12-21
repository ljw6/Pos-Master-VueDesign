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
  <a-card :title="goods.saleDate" style="height: 800px">
    <a-card-grid style="width: 100%;text-align: left">
      {{goods.goodsName}}
    </a-card-grid>
    <a-card-grid style="width: 100%;">
      {{goods.price}}
    </a-card-grid>
    <a-card-grid style="width: 100%;">
      {{goods.goodsDescription}}
    </a-card-grid>
  </a-card>
  <div style="text-align: center" v-if="goods.saleState === 'waitForPay'">
    <a-button> 付款 </a-button>
    <a-button> 取消订单 </a-button>
  </div>
  <div style="text-align: center;" v-else-if="goods.saleState === 'waitForAck'">
    <a-button> 确认收货 </a-button>
    <a-button> 拒绝收货 </a-button>
  </div>
  <div style="text-align: center;" v-else-if="goods.saleState === 'waitForComment'">
    <a-button> 去评价 </a-button>
    <a-button> 取消评价 </a-button>
  </div>
</div>
</template>

<script>
export default {
  name: "OrderDetails",
  data() {
    return {
      goods: null,
      page: null,
      // saleState: null,
    }
  },
  mounted() {
    this.getId();
    // this.doOper();
  },
  methods: {
    getId() {
      this.goods = this.$route.params.goods;
    },
  }
}
</script>

<style scoped>

</style>
