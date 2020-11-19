import Vue from "vue"
import Router from 'vue-router'
import Index from '@/components/index'
import login from '@/components/login'

Vue.use(Router)

export default new Router({
    routes : [
        {
            path: '/',
            name: 'Index',
            component: Index
        },
        {
            path: '/login',
            name: 'login',
            component: login
        }
    ]
})
