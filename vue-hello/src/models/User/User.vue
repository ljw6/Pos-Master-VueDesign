<template>
<div class="user">
  <a-layout id="components-layout-demo-side" style="min-height: 100vh">
    <a-layout-sider
        breakpoint="lg"
        collapsed-width="0"
        @collapse="onCollapse"
        @breakpoint="onBreakpoint"
    >
      <a href="/"><div class="logo"><span>师大集市</span></div></a>
      <a-menu theme="dark" mode="inline" :default-selected-keys="['1']">

        <a-menu-item key="1">
          <router-link to="/userdetails">
          <a-icon type="user" />
          <span class="nav-text">用户中心</span></router-link>
        </a-menu-item>
        <a-menu-item key="2">
          <router-link to="/allOrders/all">
          <a-icon type="project" />
          <span class="nav-text">全部订单</span>
          </router-link>
        </a-menu-item>
        <a-menu-item key="3">
          <a-icon type="shopping" />
          <span class="nav-text"> 我的购物车 </span>
        </a-menu-item>
        <a-menu-item key="4">
          <a-icon type="money-collect" />
          <span class="nav-text"> <router-link to="/myPush">我售</router-link> </span>
        </a-menu-item>
      </a-menu>
    </a-layout-sider>
    <a-layout>
      <a-layout-header class="header">
        <a-button style="margin-left: 8px" @click="logout"> 退出登录 </a-button>

        <span style="position: absolute; right: 20px">
          <a-badge :count="20" style="color: red" :overflow-count="10">
            <a href="/User">
          <a-avatar style="color: #1088e9;background-color: white;" size="large">
            <a-icon slot="icon" type="user"/>
          </a-avatar>
              </a>
          </a-badge>
        </span>
      </a-layout-header>
      <router-view v-if="isRouter"/>
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
// const user=null;
export default {
  name: "User",
  data(){
    return{
      isRouter: true,
    }
  },
  provide(){
    return {
      reload:this.reloads
    }
  },
  beforeCreate() {
    let token = localStorage.getItem('authorization');
    if(token == null){
      alert("请登录");
      self.location.href = "/login";
    }
  },
  mounted() {
    this.preloadRoutes();
  },
  methods: {
    onCollapse(collapsed, type) {
      console.log(collapsed, type);
    },
    onBreakpoint(broken) {
      console.log(broken);
    },
    preloadRoutes(){
      this.$router.push({path:'/userdetails'});
    },
    logout(){
      localStorage.clear();
      self.location.href = "/";
    },
    reloads(){
      this.isRouter = false
      this.$nextTick(() => (this.isRouter = true))
    }
  },

}
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
/*.orders .anticon{*/
/*  */
/*}*/
.orders .ant-card-grid{
  text-align: center;
  width: 25%;
}
.userUtils{
  display: flex;
  justify-content: center;
  margin-top: 60px;
}
/*.userUtils .ant-card{*/
/*  background-color: #497AC5;*/
/*}*/
</style>
