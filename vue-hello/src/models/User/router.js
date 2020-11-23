import Vue from 'vue'
import Routers from 'vue-router'
import User from './User.vue'
Vue.use(Routers)

export default new Routers({
    mode: 'history',
    routes:[
        {
            path: '/',
            name: 'User',
            component: User
        }
    ]
})
