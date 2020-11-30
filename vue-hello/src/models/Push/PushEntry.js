import Vue from 'vue'
import router from "./router";
import Pusher from "./Pusher";
import {Menu} from "ant-design-vue";
import {Layout} from "ant-design-vue";
import {Avatar} from "ant-design-vue";
import {Badge} from "ant-design-vue";
import {BackTop} from "ant-design-vue";
import {Form} from "ant-design-vue";
import {Input} from "ant-design-vue";
import {Select} from "ant-design-vue";
import {Icon} from "ant-design-vue";

Vue.use(Icon)
Vue.use(Input)
Vue.use(Select)
Vue.use(Form)
Vue.use(Menu)
Vue.use(Layout)
Vue.use(Avatar)
Vue.use(Badge)
Vue.use(BackTop)

new Vue({
    render: h=>h(Pusher),
    router
}).$mount("#pusher")
