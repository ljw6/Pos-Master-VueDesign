import Vue from 'vue'
import router from './router'
import User from "./User"
import {Layout} from 'ant-design-vue'
import {Menu} from "ant-design-vue"
import {Badge} from "ant-design-vue"
import {BackTop} from "ant-design-vue"
import {Avatar} from "ant-design-vue"
import {Icon} from "ant-design-vue"
import {Card} from "ant-design-vue";
import {Col} from "ant-design-vue"
import {Row} from "ant-design-vue";
import {List} from "ant-design-vue";
import {Steps} from "ant-design-vue"
import {Axios} from "@/Utils/axios"
import {Button} from "ant-design-vue";
import {Modal} from "ant-design-vue";

Vue.prototype.$http = Axios;
Vue.use(Steps)
Vue.use(Modal)
Vue.use(Button)
Vue.use(List)
Vue.use(Row)
Vue.use(Col)
Vue.use(Card)
Vue.use(Layout)
Vue.use(Badge)
Vue.use(Menu)
Vue.use(BackTop)
Vue.use(Avatar)
Vue.use(Icon)

new Vue({
    render: u => u(User),
    router,
}).$mount("#user")
