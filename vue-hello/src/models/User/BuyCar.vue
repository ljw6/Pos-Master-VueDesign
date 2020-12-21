<!--<template>-->
<!--<div class="car">-->
<!--  <a-list-->
<!--      class="demo-loadmore-list"-->
<!--      item-layout="vertical"-->
<!--      size="large"-->
<!--      :pagination="pagination"-->
<!--      :data-source="datalist"-->
<!--  >-->
<!--    <a-list-item slot="renderItem" key="item.title" slot-scope="item" id="waitForComment">-->
<!--      <a slot="title" href="/">{{item.goodsName}}</a>-->
<!--      <a-row type="flex" justify="start">-->
<!--        <a-col :xs="6" :lg="4">-->
<!--          <router-link to="/details/123">-->
<!--            <img :src="item.img" style="height: 150px; width: 150px" />-->
<!--          </router-link>-->
<!--        </a-col>-->
<!--        <a-col :xs="6" :lg="6">-->
<!--          <div class="goodsDetails">-->
<!--            <span>商品：{{item.goodsName}}</span>-->
<!--            <br />-->
<!--            <span>价格：{{item.price}}￥</span>-->
<!--            <br />-->
<!--            <span>交易时间：{{item.saleDate}}</span>-->
<!--          </div>-->
<!--        </a-col>-->
<!--      </a-row>-->
<!--      <span slot="extra" style="margin-top: 20px;display: flex;align-items: center;" @click="getDetail">详细信息</span>-->
<!--    </a-list-item>-->
<!--</div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--name: "BuyCar",-->
<!--  data(){-->
<!--  return{-->
<!--    datalist: [],-->
<!--    pagination: {-->
<!--      onChange: page => {-->
<!--        console.log(page);-->
<!--      },-->
<!--      pageSize: 3,-->
<!--    },-->

<!--  }-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->
