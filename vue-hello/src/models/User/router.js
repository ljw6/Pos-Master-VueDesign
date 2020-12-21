import Vue from 'vue'
import Routers from 'vue-router'
import UserDetails from "./UserDetails";
import AllOrders from "./AllOrders";
import OrderDetails from "./OrderDetails";
import BuyCar from "./BuyCar";
import myPushs from "./myPushs";
import Router from "vue-router";

Vue.use(Routers)

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
            path:'/details',
            name: "Details",
            component: OrderDetails,
        },
        {
            path: '/allOrders/:Tab',
            component: AllOrders,
            props: ordersTab
        },
        {
            path: '/car',
            component: BuyCar,
        },
        {
            path: "/myPush",
            component: myPushs
        }

    ]
})
const originalReplace = Router.prototype.replace;
Router.prototype.replace = function replace(location) {
    return originalReplace.call(this, location).catch(err => err);
};
