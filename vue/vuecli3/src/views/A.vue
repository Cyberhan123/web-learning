<template>
    <div>
        <component-b msg="这是通过msg传给的b"></component-b>
        <component-c @add="fn" :count="count"></component-c>
    </div>
</template>

<script>
    import componentB from '@/views/B.vue';
    import componentC from '@/views/C.vue';

    export default {
        name: "A",
        data(){
            return{
                count:0
            }
        },
        components: {
            componentB,
            componentC
        },
        methods:{
            fn(n){
                this.count+=n;
            }
        }
    }
</script>

<style scoped>

</style>