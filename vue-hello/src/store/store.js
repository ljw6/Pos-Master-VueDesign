import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export const store =new Vuex.Store({
    state: {
        counter:0
    },
    getters:{
        getone : (state) => {
            return state.counter*2;
        },
        gettwo : state => {
            return state.counter-1;
        }
    },
    mutations:{
        addfunc : state => {
            return state.counter++;
        },
        divfunc : state => {
            return state.counter--;
        }
    }

})
