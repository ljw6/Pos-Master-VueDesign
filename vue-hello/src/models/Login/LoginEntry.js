import Vue from 'vue'
import Login from "./Login";
import {Form} from "ant-design-vue";
import {Button} from "ant-design-vue";
import {Input} from "ant-design-vue";
import {Icon} from "ant-design-vue";
import {FormModel} from "ant-design-vue";
import {Checkbox} from "ant-design-vue";
import {Card} from "ant-design-vue";

Vue.use(Card)
Vue.use(Checkbox)
Vue.use(Form)
Vue.use(Icon)
Vue.use(Input)
Vue.use(Button)
Vue.use(FormModel)

new Vue({
    render: h=>h(Login),
}).$mount("#login");
