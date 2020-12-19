import Vue from 'vue'
import GoodDetails from "./GoodDetails";



// 设置浏览器标题
Vue.directive('title', {
    inserted: function (el, binding) {
        document.title = el.dataset.title
    }
})
new Vue({
    render: h => h(GoodDetails),
}).$mount("#Goods")
