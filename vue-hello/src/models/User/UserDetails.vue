<template>
<div class="userdetails">
  <a-layout>
    <div class="userUtils">
      <a-row type="flex" style="width: 1000px;">
        <a-col flex="300px">
          <a-card hoverable style="height: fit-content">
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
        </a-col>
        <a-col flex="auto">
          <a-card hoverable style="width: auto" title="我的订单" class="orders">
            <router-link to="/allOrders/waitForPay">
            <a-card-grid>
              <a-icon type="wallet"/>
              <p>待付款</p>
            </a-card-grid>
            </router-link>
            <router-link to="/allOrders/waitForComment">
            <a-card-grid>
              <a-icon type="message" />
              <p>待评价</p>
            </a-card-grid>
            </router-link>
            <router-link to="/allOrders/waitForRecv">
              <a-card-grid>
                <a-icon type="inbox" />
                <p>待收货</p>
              </a-card-grid>
            </router-link>
            <router-link to="/allOrders/waitForAck">
            <a-card-grid>
              <a-icon type="right-circle" />
              <p>待确认</p>
            </a-card-grid>
            </router-link>
          </a-card>
        </a-col>
      </a-row>
    </div>
  </a-layout>
</div>
</template>

<script>
export default {
name: "UserDetails"
}
</script>

<style scoped>
.orders .ant-card-grid{
  text-align: center;
  width: 25%;
}
.userUtils{
  display: flex;
  justify-content: center;
  margin-top: 60px;
}
</style>
