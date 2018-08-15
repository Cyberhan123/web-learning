<template>
    <div>
        <button @click="$emit('add',2)">add</button>
        <h1>{{count}}</h1>
    </div>
</template>

<script>
    export default {
        name: "C",
        props:['count']
    }
</script>

<style scoped>

</style>