import Router from "vue-router";
import Vue from 'vue'
import PayGoods from "./PayGoods";
import Goods from "./Goods";

Vue.use(Router)
export default new Router(
    {
        mode: "history",
        routes:[
            {
                path:"/goods",
                name: "Goods",
                component: Goods,
            },
            {
                path: "/pay",
                component: PayGoods,
                name: "Pay"
            }
        ]
    }
)
const originalReplace = Router.prototype.replace;
Router.prototype.replace = function replace(location) {
    return originalReplace.call(this, location).catch(err => err);
};
