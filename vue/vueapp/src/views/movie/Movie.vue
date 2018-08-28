<template>
    <div>
        <div class="movie">
            <ul>
                <item-bar v-for="i in movieList" :movie="i" @click.native="getDetail(i)"></item-bar>
            </ul>
        </div>
        <div class="loading" v-show="isLoad">
            <img src="../../assets/load.gif" alt="">
        </div>
        <div class="bot" v-show="isEnd">
            到底部了。。。。
        </div>
    </div>
</template>

<script>
    import Axios from 'axios';
    import ItemBar from '@/components/ItemBar.vue';

    export default {
        data() {
            return {
                movieList: [],
                isLoad: false,
                isEnd: false,
            }
        },
        //create
        created() {
            //https://www.cnblogs.com/trackingmore/p/7156877.html
            //https://developers.douban.com/wiki/?title=movie_v2
            // Axios.get('/theaters.json')
            //     .then((res) => {
            //         this.movieList = res.data.subjects;
            //         console.log(this.movieList);
            //     });
            this.getData();
            window.onscroll = () => {
                var scrollTop = document.documentElement.scrollTop;
                var scrollHeight = document.documentElement.scrollHeight;
                var clientHeight = document.documentElement.clientHeight;
                if ((clientHeight + scrollTop) === scrollHeight && !this.isEnd) {
                    this.isLoad = true;
                    this.getData();
                }
            }
        },
        components: {
            ItemBar,
        },
        methods: {
            getData() {
                Axios.get('http://testing.hselfweb.cn/accept.php?url=https://api.douban.com/v2/movie/in_theaters')
                    .then((res) => {
                        var arr = res.data.subjects.slice(this.movieList.length, this.movieList.length + 5);
                        console.log(arr);
                        this.movieList = [...this.movieList, ...arr];
                        this.isShow = false;
                        if (this.movieList.length >= 20) {
                            console.log(1111);
                            this.isLoad = false;
                            this.isEnd = true;
                        }
                    });
            },
            getDetail(item){
               this.$router.push('/movie-detail/'+item.id);
            }
        }
    }
</script>

<style scoped lang="scss">
    .movie li {
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

    .loading {
        width: 50px;
        margin: 0 auto;
        img {
            width: 50px;
        }
    }

    .bot {
        /*border: cornflowerblue 1px solid;*/
        /*width: 5rem;*/
        color: #ffffff;
        height: .7rem;
        border-radius: 50% 50% 0 0;
        margin: 10px auto;
        line-height: .7rem;
        text-align: center;
        background: gray;
    }
</style>