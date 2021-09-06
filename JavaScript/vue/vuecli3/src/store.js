import Vue from 'vue';
import Vuex from 'vuex';

/**
 * @description:
 * 同步交互：指发送一个请求,需要等待返回,然后才能够发送下一个请求，有个等待过程；
 *异步交互：指发送一个请求,不需要等待返回,随时可以再发送下一个请求，即不需要等待。
 */
Vue.use(Vuex);

export default new Vuex.Store({
    //相当与原生的data
    state: {
        count: 2
    },
    //相当于原生的方法属性methods，同步的
    mutations: {
        add(state) {

        }
    },
    //相当于原生的计算属性computed
    getters: {},
    //控制异步操作,可以写逻辑
    actions: {
        addnum({commit}) {
            commit('add')
        }
    },
});
