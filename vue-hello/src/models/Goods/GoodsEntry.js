import Vue from 'vue'
import GoodDetails from "./GoodDetails";
import {Layout} from "ant-design-vue";
import {Badge} from "ant-design-vue";
import {Avatar} from "ant-design-vue";
import {Dropdown} from "ant-design-vue";
import {Icon} from "ant-design-vue";
import {Menu} from "ant-design-vue";
import {Button} from "ant-design-vue";
import {Axios} from "@/Utils/axios"
import {Descriptions} from "ant-design-vue";
import router from './router'
import Tokener from '@/Utils/filter'
import {Modal} from "ant-design-vue";

Vue.prototype.$http = Axios;
Vue.prototype.$tokener = Tokener;
Vue.use(Button)
Vue.use(Modal)
Vue.use(Descriptions)
Vue.use(Layout)
Vue.use(Badge)
Vue.use(Avatar)
Vue.use(Dropdown)
Vue.use(Icon)
Vue.use(Menu)

// 设置浏览器标题
// Vue.directive('title', {
//     inserted: function (el, binding) {
//         document.title = el.dataset.title
//     }
// })
new Vue({
    render: h => h(GoodDetails),
    router,
}).$mount("#Goods")
