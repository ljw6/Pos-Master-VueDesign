import Vue from 'vue'
import Router from './router'
import User from "./User.vue";

new Vue({
    render: u => u(User),
    Router,
}).$mount("#user")
