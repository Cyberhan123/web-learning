import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
      menuList:[{
          name:'电影',
          path:'/movie',
          bgColor:'rgb(33, 150, 243)',
          title:'movie'
      },{
          name:'音乐',
          path:'/music',
          bgColor:'rgb(0, 150, 136)',
          title:'music'
      },{
          name:'书籍',
          path:'/book',
          bgColor:'rgb(121, 85, 72)',
          title:'book'
      },{
          name:'图片',
          path:'/photo',
          bgColor:'#3f51b5',
          title:'photo'
      }],
      menu:{}
  },
  mutations: {

  },
  actions: {

  },
});
