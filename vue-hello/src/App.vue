<template>
  <div>
  <a-layout id="components-layout-demo-side" style="min-height: 100vh">
    <a-layout-sider v-model="collapsed" collapsible>
      <div class="logo" ><span>{{collapsed?'Market':'二手市场'}}</span></div>
      <a-menu theme="dark" :default-selected-keys="['1']" mode="inline">
        <a-menu-item key="1">
          <a-icon type="pie-chart" />
          <span>Option 1</span>
        </a-menu-item>
        <a-menu-item key="2">
          <a-icon type="desktop" />
          <span>Option 2</span>
        </a-menu-item>
        <a-sub-menu key="sub1">
          <span slot="title"><a-icon type="user" /><span>User</span></span>
          <a-menu-item key="3">
            Tom
          </a-menu-item>
          <a-menu-item key="4">
            Bill
          </a-menu-item>
          <a-menu-item key="5">
            Alex
          </a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub2">
          <span slot="title"><a-icon type="team" /><span>Team</span></span>
          <a-menu-item key="6">
            Team 1
          </a-menu-item>
          <a-menu-item key="8">
            Team 2
          </a-menu-item>
        </a-sub-menu>
        <a-menu-item key="9">
          <a-icon type="file" />
          <span>File</span>
        </a-menu-item>
      </a-menu>
    </a-layout-sider>
    <a-layout>
      <a-layout-header class="header">
        <span style="position: relative; left: 1200px">
          <a-badge :count="1" style="color: red">
            <router-link to="/user">
          <a-avatar style="color: #1088e9;background-color: white;right: 50px" :size="200">
            <a-icon slot="icon" type="user"/>
          </a-avatar>
              </router-link>
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
  }
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
  height: 45px;
}
</style>
