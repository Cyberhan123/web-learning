<template>
    <div>
        <h1>Hello World</h1>
        <!--router-view是模板显示的位置-->
        <router-view/>
    </div>
</template>

<script>
    import HelloWorld from '@/components/HelloWorld.vue';

    export default {
        name: "My",
        components: {
            HelloWorld,
        },
    }
</script>

<style scoped>

</style>