<template>
    <div class="movie-detail" v-if="finish">
        <h1>{{$route.params.id}}</h1>
        <h3>名称:{{movieDetail.title}}</h3>
        <img :src="movieDetail.images.small" alt="">
        <p>简介:{{movieDetail.summary}}</p>
    </div>
</template>

<script>
    import Axios from 'axios';

    export default {
        name: "movieDetail",
        data() {
            return {
                finish: false,
            }
        },
        created() {
            var movieId = this.$route.params.id;
            // Axios.get('/detail.json'+movieId)
            Axios.get('/detail.json')
                .then((res) => {
                    this.movieDetail = res.data;
                    this.finish = true;
            });
        }
    }
</script>

<style scoped>

</style>