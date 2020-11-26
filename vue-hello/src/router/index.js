import Vue from "vue"
import Router from 'vue-router'
// import Index from '@/components/index'
import login from '@/components/login'
import Home from '@/view/Home'
import Index from '@/view/Index'
// import User from '@/view/User'
import Lists from '@/view/GoodsList'

Vue.use(Router)

export default new Router({
    //修改模式
    mode: "history",
    routes : [
        {
            path: '/',
            name: 'Index',
            component: Index,
            children: [
                {
                  path: '/list', component: Lists,
                },
            ]
        },
        {
            path: '/login',
            name: 'login',
            component: login
        },
        {
            path: '/home',
            component: Home
        },
        {
            path: '/lists',
            component: Lists,
        }
    ]
})
