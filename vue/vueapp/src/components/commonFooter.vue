<template>
    <div class="footer" :style="{background:$store.state.menu.bgColor}">
        <ul>
            <li v-for="menu in $store.state.menuList" @click="$store.state.menu=menu">
                <router-link :to="menu.path">{{menu.name}}</router-link>
            </li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: "commonFooter",
    }
</script>

<style scoped lang="scss">
    .footer {
        height: 0.8rem;
        width: 100%;
        background: rgb(33, 150, 243);
        color: #fff;
        position: fixed;
        bottom: 0;
        line-height: 0.8rem;
        ul {
            display: flex;
        }
        li {
            flex-grow: 1;
            text-align: center;
            a {
                color: #ccc;
                outline: none;
                &.router-link-active {
                    color: #fff;
                }
            }
        }
    }
</style>