import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import My from './views/My.vue';
import Test1 from './views/Test1';
import Test2 from './views/Test2';
import Test3 from './views/Test3';
import Test4 from './views/Test4';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home,
        },
        {
            path: '/about',
            name: 'about',
            alias:'/biem',
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
                    path:'test2',
                    component:Test2
                },
                {
                    path: 'test3',
                    name: 'test3',
                    component: Test3
                },
                {
                    path:'test4/:name',
                    component:Test4
                }
            ]
        },
        {
            path:'/home',
            redirect:'/'
        },
        {
            path:'/home/:name',
            redirect:'/my/test4/:name'
        }
    ],
});
