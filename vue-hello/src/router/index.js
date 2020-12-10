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
                    path: "/list",name:"lists",component: Lists,meta: {requiresAuth: true}
                }
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
    ],
    active:function (transaction){
        transaction.next()
    }
})
const originalPush = Router.prototype.push;
Router.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err);
};
const originalReplace = Router.prototype.replace;
Router.prototype.replace = function replace(location) {
    return originalReplace.call(this, location).catch(err => err);
};
