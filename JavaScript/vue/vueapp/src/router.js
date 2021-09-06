import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';

Vue.use(Router);

export default new Router({
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
            // route level code-splitting
            // this generates a separate chunk (about.[hash].js) for this route
            // which is lazy-loaded when the route is visited.
            component: () => import(/* webpackChunkName: "about" */ './views/About.vue'),
        },
        {
            path: '/movie',
            component:()=>import('./views/movie/Movie.vue')
        },
        {
            path: '/book',
            component:()=>import('./views/book/Book.vue')
        },
        {
            path: '/music',
            component:()=>import('./views/music/Music.vue')
        },
        {
            path: '/photo',
            component:()=>import('./views/photo/Photo.vue')
        }, {
            path: '/movie-detail/:id',
            component:()=>import('./views/movie/movieDetail.vue')
        },
    ],
});
