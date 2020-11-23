<template>
<div class="user">
  <a-layout id="components-layout-demo-side" style="min-height: 100vh">
    <a-layout-sider
        breakpoint="lg"
        collapsed-width="0"
        @collapse="onCollapse"
        @breakpoint="onBreakpoint"
    >
      <div class="logo"><span>二手市场</span></div>
      <a-menu theme="dark" mode="inline" :default-selected-keys="['4']">
        <a-menu-item key="1">
          <a-icon type="user" />
          <span class="nav-text">nav 1</span>
        </a-menu-item>
        <a-menu-item key="2">
          <a-icon type="video-camera" />
          <span class="nav-text">nav 2</span>
        </a-menu-item>
        <a-menu-item key="3">
          <a-icon type="upload" />
          <span class="nav-text">nav 3</span>
        </a-menu-item>
        <a-menu-item key="4">
          <a-icon type="user" />
          <span class="nav-text">nav 4</span>
        </a-menu-item>
      </a-menu>
    </a-layout-sider>
    <a-layout>
      <a-layout-header class="header">
        <span style="position: relative; left: 1200px">
          <a-badge :count="1" style="color: red" :overflow-count="10">
            <router-link to="/user">
          <a-avatar style="color: #1088e9;background-color: white;" size="large">
            <a-icon slot="icon" type="user"/>
          </a-avatar>
              </router-link>
          </a-badge>
        </span>
      </a-layout-header>
      <router-view/>
      <a-layout>
        <a-card hoverable style="width: 300px">
          <template slot="actions">
            <a-icon key="setting" type="setting"/>
            <a-icon key="edit" type="edit" />
            <a-icon key="ellipsis" type="ellipsis" />
          </template>
          <a-card-meta title="用户名" description="用户详细">
            <a-avatar
                slot="avatar" icon="user">
            </a-avatar>
          </a-card-meta>
        </a-card>
        <a-card hoverable style="width: auto" title="我的订单" :body-style="{width:'60px'}">
          <template slot="actions">
            <span id="icons"><a-icon key= "wallet" type="wallet"/></span>
            <a-icon key= "shopping-cart" type="shopping-cart" />
            <a-icon key="message" type="message" />
          </template>
        </a-card>
      </a-layout>
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
name: "User",
  methods: {
    onCollapse(collapsed, type) {
      console.log(collapsed, type);
    },
    onBreakpoint(broken) {
      console.log(broken);
    },
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
</style>
