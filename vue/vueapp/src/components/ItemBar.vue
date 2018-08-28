<template>
    <li>
        <div class="movie-img">
            <img :src="movie.images.small" alt="">
        </div>
        <div class="movie-desc">
            <h3>{{movie.title}}</h3>
            <p>观众评 <span class="aver">{{movie.rating.average}}</span></p>
            主演：<span v-for="actor in movie.casts">{{actor.name }} </span>
        </div>
    </li>
</template>

<script>
    export default {
        name: "ItemBar",
        props: ['movie']
    }
</script>

<style scoped lang="scss">
     li {
        display: flex;
        padding: 10px;
        .movie-img {
            flex-grow: 1;
            width: 0;
        }
        .movie-desc {
            flex-grow: 3;
            width: 0;
            margin-left: 20px;
            .aver {
                color: orange;
            }
        }
    }
</style>