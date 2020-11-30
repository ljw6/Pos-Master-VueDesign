import Vue from 'vue'
import Routers from "vue-router"
import Pusher from "./Pusher";
import PushGoods from "./PushGoods";

Vue.use(Routers)

export default new Routers({
    mode: 'history',
    routes:[
        {
            path: '/',
            name: 'Pusher',
            component: Pusher
        },
        {
            path: '/Pushgoods',
            name: 'PushGoods',
            component: PushGoods
        }
    ]
})
