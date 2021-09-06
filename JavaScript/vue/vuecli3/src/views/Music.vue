<template>
    <div>
        <ul>
            <li v-for="i in list">
                <router-link :to="'/musicdatil/'+i.id">{{i.name}}{{i.singer}}</router-link>
            </li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: "movie",
        data(){
            return {
                list:[
                    {id:1,name:"青花瓷",singer:"周杰伦"},
                    {id:2,name:"菊花台",singer:"周杰伦"},
                    {id:3,name:"田花错",singer:"王力宏"}
                ]
            }
        }
    }
</script>

<style scoped>

</style>