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
import {BackTop} from "ant-design-vue";
import {Badge} from "ant-design-vue";
import {Avatar} from "ant-design-vue";
import {Tabs} from "ant-design-vue";
import {Collapse} from "ant-design-vue";
import {Row} from "ant-design-vue";
import {Col} from "ant-design-vue";
import {Dropdown} from "ant-design-vue";
import {List} from "ant-design-vue";
import {Card} from "ant-design-vue";

Vue.use(Card)
Vue.use(List)
Vue.use(Dropdown)
Vue.use(Row)
Vue.use(Col)
Vue.use(Collapse)
Vue.use(Tabs)
Vue.use(Avatar)
Vue.use(Badge)
Vue.use(BackTop)
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
