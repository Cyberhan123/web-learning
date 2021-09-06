<template>
    <div id="app">
        <div id="nav">
            <router-link to="/">Home</router-link>
            |
            <router-link to="/about">About</router-link>
            |
            <router-link to="/my">My</router-link>
            |
            <router-link to="/my/test1">子路由1</router-link>
            |
            <router-link to="/my/test2">子路由2</router-link>
            |
            <router-link :to="{name:'test3',params:{name:'hello'}}">子路由3</router-link>
            |
            <router-link to="/my/test4/hello">子路由4</router-link>
            |
            <router-link to="/home">返回首页（重定向）</router-link>
            |
            <router-link to="/home/wangwu">重定向参数</router-link>
            |
            <router-link to="/biem">别名</router-link>
            |
            <router-link to="/music">传值给子页面</router-link>
        </div>
        <!--router-view是模板显示的位置-->
        <transition name="fade" model="out-in">
        <router-view/>
        </transition>
    </div>
</template>

<style lang="scss">
    .fade-enter{
        opacity: 0;
    }
    .fade-enter-active{
       transition:opacity 2s linear;
    }
    .fade-enter-to{
        opacity: 100;
    }
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }

    #nav {
        padding: 30px;
        a {
            font-weight: bold;
            color: #2c3e50;
            &.router-link-exact-active {
                color: #42b983;
            }
        }
    }
</style>
