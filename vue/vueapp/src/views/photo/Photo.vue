<template>
    <div class="photo">
        <div class="small-img" v-show="isSmall">
            <img v-for="img in imgList" :src="img.src" alt="" @click="whichImg(img)">
        </div>
        <div class="big-img" v-show="isBig">
            <v-touch @swipeleft="sLeft" @swiperight="sRight">
                <img :src="imgUrl" alt="" @click="reBack">
            </v-touch>
        </div>
    </div>
</template>

<script>
    import Axios from 'axios';

    export default {
        name: "Photo",
        data() {
            return {
                imgList: [],
                isSmall: true,
                isBig: false,
                imgUrl: ""
            }
        },
        methods: {
            whichImg(img) {
                this.isSmall = false;
                this.isBig = true;
                this.imgUrl = img.src;
            },
            reBack() {
                this.isSmall = true;
                this.isBig = false;
            },
            sRight() {

                var pos = this.getPos() - 1;
                if (this.imgList.length > pos && pos > -1)
                    this.imgUrl = this.imgList[pos].src;
                else
                    this.imgUrl = this.imgList[this.imgList.length - 1].src;
            },
            sLeft() {
                var pos = this.getPos() + 1;
                if (this.imgList.length > pos && pos > -1)
                    this.imgUrl = this.imgList[pos].src;
                else
                    this.imgUrl = this.imgList[0].src;
            },
            getPos() {
                for (var i = 0; i < this.imgList.length; i++) {
                    if (this.imgList[i].src === this.imgUrl) {
                        return i;
                    }
                }
            }

        },
        created() {
            Axios.get("/photo.json").then((res) => {
                this.imgList = res.data.photoData;
            })
        }
    }
</script>

<style scoped lang="scss">
    .small-img {
        width: 6.2rem;
        margin: 50px auto;
        img {
            width: 2rem;
            border-right: 2px solid black;
            border-bottom: 2px solid black;
        }
    }
    .big-img{
        position: absolute;
        top: 50%;
        height: 240px;
        margin-top: -120px; /* negative half of the height */
    }
    .header{
        z-index: 1;
    }
</style>