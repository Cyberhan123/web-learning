<template>
    <div class="header" :style="{background:$store.state.menu.bgColor}">
        <span class="header-home">首页</span>
        <h2 class="header-title">{{$store.state.menu.name}}</h2>
    </div>
</template>

<script>
    export default {
        name: "commonHeader",
    }
</script>

<style scoped lang="scss">
    .header {
        height: 0.8rem;
        width: 100%;
        background: rgb(33, 150, 243);
        color: #fff;
        position: fixed;
        top: 0;
        line-height: 0.8rem;
        &-home {
            font-size: 0.3rem;
            margin: 10px;
        }
        &-title {
            font-size: 0.4rem;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
    }
</style>