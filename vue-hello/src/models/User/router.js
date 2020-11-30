import Vue from 'vue'
import Routers from 'vue-router'
import UserDetails from "./UserDetails";
import AllOrders from "./AllOrders";
import OrderDetails from "./OrderDetails";

Vue.use(Routers)

function goodIdFn(route){
    return {
        name: parseInt(route.params.int)
    }
}

function ordersTab(route){
    return{
        name: route
    }
}

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
        },
        {
            path:'/details/:goodsId',
            component: OrderDetails,
            props: goodIdFn
        },
        {
            path: '/allOrders/:Tab',
            component: AllOrders,
            props: ordersTab
        }

    ]
})
