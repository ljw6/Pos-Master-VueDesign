<template>
<div>
  <a-layout>
    <a-layout-header class="header">
        <span style="position: absolute;right: 65px">
          <a-dropdown>
      <a-menu slot="overlay">
        <a-menu-item key="1" @click="turnToPushGoods('Pushgoods')"> <a-icon type="user" />发布物品</a-menu-item>
        <a-menu-item key="2" @click="turnToPushGoods('Pushservices')"> <a-icon type="user" />发布任务</a-menu-item>
      </a-menu>
      <a-button style="margin-left: 8px"> 我要 <a-icon type="down" /> </a-button>
    </a-dropdown>
        </span>

      <span style="position: absolute; right: 20px">
          <a-badge :count="1" style="color: red">
            <a href="/User">
          <a-avatar style="color: #1088e9;background-color: white;" size="large">
            <a-icon slot="icon" type="user"/>
          </a-avatar>
              </a>
          </a-badge>
        </span>
    </a-layout-header>
    <div class="goodsContent">
      <a-layout-content style="padding: 0 50px">
        <div :style="{ background: '#fff', padding: '24px', minHeight: '280px' }">
        <router-view/>
        </div>
      </a-layout-content>
    </div>
  </a-layout>
</div>
</template>

<script>


export default {
  mounted() {
    this.$router.replace({path:"/goods",query:{id:this.getId()}})
  },
  name: "GoodDetails",
  // data(){
  //   return{
  //   }
  // },
  methods:{
    getId(){
      return  window.location.href.split("?")[1].split("=")[1];
    }
  }
}
</script>

<style scoped>
.header{
  background-color: #001529;
  height: 55px;
}
</style>
