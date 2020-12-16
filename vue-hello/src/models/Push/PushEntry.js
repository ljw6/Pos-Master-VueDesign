import Vue from 'vue'
import router from "./router";
import Pusher from "./Pusher";
import {Menu} from "ant-design-vue";
import {Layout} from "ant-design-vue";
import {Avatar} from "ant-design-vue";
import {Badge} from "ant-design-vue";
import {BackTop} from "ant-design-vue";
import {FormModel} from "ant-design-vue";
import {Input} from "ant-design-vue";
import {Select} from "ant-design-vue";
import {Icon} from "ant-design-vue";
import {DatePicker} from "ant-design-vue";
import {Upload} from "ant-design-vue";
import {Axios} from "@/Utils/axios"
import {Button} from "ant-design-vue";

Vue.prototype.$http = Axios;

Vue.use(Button)
Vue.use(Upload)
Vue.use(DatePicker)
Vue.use(Icon)
Vue.use(Input)
Vue.use(Select)
Vue.use(FormModel)
Vue.use(Menu)
Vue.use(Layout)
Vue.use(Avatar)
Vue.use(Badge)
Vue.use(BackTop)

new Vue({
    render: h=>h(Pusher),
    router
}).$mount("#pusher")
