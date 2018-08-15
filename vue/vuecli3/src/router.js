import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import My from './views/My.vue';
import Test1 from './views/Test1';
import Test2 from './views/Test2';
import Test3 from './views/Test3';
import Test4 from './views/Test4';
import Error from './views/Error';
import Music from './views/Music';
import MusicD from './views/MusicDatil';
import VueX from './views/VueX';
import A from './views/A';

Vue.use(Router);

var router = new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home,
        },
        {
            path: '/about',
            name: 'about',
            alias: '/biem',
            // route level code-splitting
            // this generates a separate chunk (about.[hash].js) for this route
            // which is lazy-loaded when the route is visited.
            component: () => import(/* webpackChunkName: "about" */ './views/About.vue'),
        },
        {
            path: '/my',
            name: 'my',
            // route level code-splitting
            // this generates a separate chunk (about.[hash].js) for this route
            // which is lazy-loaded when the route is visited.
            component: My,
            children: [
                {
                    path: 'test1',
                    component: Test1
                },
                {
                    path: 'test2',
                    component: Test2
                },
                {
                    path: 'test3',
                    name: 'test3',
                    component: Test3
                },
                {
                    path: 'test4/:name',
                    component: Test4
                }
            ]
        },
        {
            path: '/home',
            redirect: '/'
        },
        {
            path: '/home/:name',
            redirect: '/my/test4/:name'
        },
        {
            path: '*',
            component: Error
        },
        {
            path:'/music',
            component:Music
        },
        {
            path:'/musicdatil/:id',
            component:MusicD
        },{
        path:'/vuex',
            component:VueX,
        },{
        path:'/a',
            component:A
        }
    ],
    // 全局组件
    //跳转之前执行
});
// router.beforeEach((to, from, next) => {
//     // next();
//     //跳转之后执行
// });
// router.afterEach((to, from, next) => {
//     // next();
// });
export default router;
