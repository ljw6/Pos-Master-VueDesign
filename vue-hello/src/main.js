import Vue from 'vue'
import App from './App.vue'
import {store} from './store/store'
import router from './router'
import {Axios} from "@/Utils/axios"
import {Button} from 'ant-design-vue'
import {Icon} from 'ant-design-vue'
import {Result} from 'ant-design-vue'
import {Menu} from 'ant-design-vue'
import {Affix} from "ant-design-vue";
import {Layout} from "ant-design-vue";

Vue.use(Layout)
Vue.use(Affix)
Vue.use(Button)
Vue.use(Icon)
Vue.use(Result)
Vue.use(Menu)

Vue.config.productionTip = false
Vue.prototype.$http = Axios;

new Vue({
    render: h => h(App),
    store,
    router,
}).$mount('#app')
