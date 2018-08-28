<template>
    <div class="music" v-if="finish">
    <aplayer :music="musicList[0]" :list="musicList" v-if="finish" :showLrc="true"></aplayer>
    </div>
</template>

<script>
    import Aplayer from 'vue-aplayer';
    import Axios from 'axios';

    export default {
        name: "Music",
        data() {
            return {
                musicList: [],
                finish:false
            }
        },
        components: {
            Aplayer,
        },
        created() {
            Axios.get("/music.json").then((res) => {
                this.musicList = res.data.musicData;
                this.finish=true;
            })
        }
    }
</script>

<style scoped>
.music{
    overflow: hidden;
}
</style>