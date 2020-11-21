import Vue from "vue"
import Router from 'vue-router'
import Index from '@/components/index'
import login from '@/components/login'
import Home from '@/view/Home'

Vue.use(Router)

export default new Router({
    //修改模式
    mode: "history",
    routes : [
        {
            path: '/index',
            name: 'Index',
            component: Index
        },
        {
            path: '/login',
            name: 'login',
            component: login
        },
        {
            path: '/',
            component: Home
        }
    ]
})
