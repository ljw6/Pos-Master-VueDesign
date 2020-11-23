import Vue from 'vue'
import Routers from 'vue-router'
// import User from './User.vue'
import UserDetails from "./UserDetails";
import AllOrders from "./AllOrders";
Vue.use(Routers)

export default new Routers({
    mode: 'history',
    routes:[
        {
            path: '/',
            name: 'User',
            component: require('./UserDetails'),
        },
        {
            path: '/userdetails',
            name: 'userdetail',
            component: UserDetails
        },
        {
            path: '/allOrders',
            name: 'AllOrders',
            component: AllOrders
        }

    ]
})
