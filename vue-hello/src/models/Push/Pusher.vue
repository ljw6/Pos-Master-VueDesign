<template>
<div class="push">
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
          <router-link to="/Pushgoods">
            <a-icon type="gold" />
            <span class="nav-text">发布商品</span></router-link>
        </a-menu-item>
        <a-menu-item key="2">
          <router-link to="/Pushservices">
            <a-icon type="user" />
            <span class="nav-text">发布任务</span>
          </router-link>
        </a-menu-item>
      </a-menu>
    </a-layout-sider>
    <a-layout>
      <a-layout-header class="header">
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
name: "Pusher",
  mounted() {
  // this.getDefaultPage();
  },
  methods: {
    onCollapse(collapsed, type) {
      console.log(collapsed, type);
    },
    onBreakpoint(broken) {
      console.log(broken);
    },
    getDefaultPage(){
      this.$router.push("/Pushgoods");
    }
}
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
</style>
