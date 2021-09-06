<template>
    <div id="app">
        <cheader></cheader>
        <router-view class="content"></router-view>
        <cfooter></cfooter>
    </div>
</template>
<script>
    import cheader from '@/components/commonHeader.vue';
    import cfooter from '@/components/commonFooter.vue'

    export default {
        name: "App",
        // data() {
        //
        // },
        components: {
            cheader,
            cfooter
        },
        created(){
            // var path = this.$route.path;
            // var menu = this.menuList.filter(elem=>{
            //     return elem.path === path;
            // });
        }
    }
</script>
<style scoped lang="scss">
    .content {
        margin: 0.8rem 0;
    }
</style>
