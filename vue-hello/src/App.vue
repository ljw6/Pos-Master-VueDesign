<template>
  <div>
  <a-layout id="components-layout-demo-side" style="min-height: 100vh">
    <a-layout-sider v-model="collapsed" collapsible>
      <a href="/" ><div class="logo" ><span>{{collapsed?'Market':'师大集市'}}</span></div></a>
      <a-menu theme="dark" :default-selected-keys="['1']" mode="inline" @click="handleMenuClick">
        <a-sub-menu key="area" @titleClick="subClick">
          <span slot="title"><a-icon type="home" /><span>园区分布</span></span>
          <a-menu-item key="1">
            周园
          </a-menu-item>
          <a-menu-item key="2">
            秦园
          </a-menu-item>
          <a-menu-item key="3">
            汉园
          </a-menu-item>
          <a-menu-item key="4">
            唐园
          </a-menu-item>
          <a-menu-item key="5">
            梅园
          </a-menu-item>
          <a-menu-item key="6">
            兰园
          </a-menu-item>
          <a-menu-item key="7">
            竹园
          </a-menu-item>
          <a-menu-item key="8">
            菊园
          </a-menu-item>
          <a-menu-item key="9">
            家属区
          </a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="catergery">
        <span slot="title"><a-icon type="appstore" /><span>实物商品</span></span>
          <a-menu-item key="1">
            美妆护肤
          </a-menu-item>
          <a-menu-item key="2">
            消费电子
          </a-menu-item>
          <a-menu-item key="3">
            学习用具
          </a-menu-item>
          <a-menu-item key="4">
            生活用品
          </a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="service">
          <span slot="title"><a-icon type="user" /><span>校园服务</span></span>
          <a-menu-item key="1">
            跑腿
          </a-menu-item>
          <a-menu-item key="2">
            辅导
          </a-menu-item>
          <a-menu-item key="3">
            代做
          </a-menu-item>
        </a-sub-menu>
      </a-menu>
    </a-layout-sider>
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
      <router-view/>
    </a-layout>
    <div id="components-back-top-demo-custom">
      <a-back-top>
        <div class="ant-back-top-inner">
          UP
        </div>
      </a-back-top>
    </div>
  </a-layout>
  </div>
</template>

<script>
export default {
  name: "app",
  data() {
    return {
      collapsed: false,
    };
  },
  methods:{
    handleMenuClick(val){
      console.log(val.keyPath[0]);
      console.log(val.keyPath[1]);
      this.$router.replace({path:"/lists",query:{tabTag:val.keyPath[1],tagVal:val.keyPath[0]}});
      this.$router.go(0);
    },
    turnToPushGoods(url){
        self.location.href= "/doPush?routeUrl="+url;
    },
    subClick(val){
      console.log(val);
    }
  },
  // watch:{
  //   $route(to,from){
  //     alert(to);
  //     console.log(from);
  //   }
  // }
};
</script>

<style scoped>
#components-layout-demo-side .logo {
  height: 32px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px;
}
#components-back-top-demo-custom .ant-back-top{
  bottom: 50px;
}
#components-back-top-demo-custom .ant-back-top-inner {
  /*position: fixed;*/
  /*right: 50px;*/
  /*bottom: 50px;*/
  height: 40px;
  width: 40px;
  line-height: 40px;
  border-radius: 4px;
  background-color: #1088e9;
  color: #fff;
  text-align: center;
  font-size: 20px;
}
.logo{
  text-align: center;
  color: white;
}
.logo span{
  vertical-align: middle;
}
.header{
  background-color: #001529;
  height: 55px;
}
</style>
