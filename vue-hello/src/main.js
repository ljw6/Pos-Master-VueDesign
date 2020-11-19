import Vue from 'vue'
import App from './App.vue'
import {store} from './store/store'
import router from './router'
import {Axios} from "@/Utils/axios"
// import Antd from 'ant-design-vue'
import {Button} from 'ant-design-vue'

Vue.use(Button)

Vue.config.productionTip = false
Vue.prototype.$http = Axios;

new Vue({
    render: h => h(App),
    store,
    router,
}).$mount('#app')
