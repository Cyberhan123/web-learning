/**
 * @author: Cyberhan
 * @filename: module
 * @description: 这里存储了基本配置对象，光进行函数调用不传值默认
 * 开启所有默认配置，也可以自定义开启一些配置~~详细看数组代码65行
 * 参数为：string类型的字符串，不限制个数哦
 * */
const ExtractTextPlugin = require("extract-text-webpack-plugin");
const css = {
    test: /\.css$/,
    //这两个不能写反
    //use:['style-loader','css-loader']
    //额外加载
    use: ExtractTextPlugin.extract({
        fallback: "style-loader",
        use: "css-loader"
    })
};
const img = {
    test: /\.(png|jpg|gif)/i,
    use: [{
        loader: 'url-loader',
        options: {
            limit: 500,
            outputPath: 'images/'
        }
    }, /*'postcss-loader'*/]
};
const html = {

    test: /\.(htm|html)$/i,
    loader: 'html-withimg-loader'
};
const sass = {
    test: /\.scss$/,
    //嵌入js
    // use:[
    //     {
    //         loader:'style-loader'
    //     },
    //     {
    //         loader:'css-loader'
    //     },
    //     {
    //         loader:'sass-loader'
    //     }
    // ]
    //额外加载
    //额外加载也要在入口js引入！！！！！！！！！！！
    use: ExtractTextPlugin.extract({
        fallback: 'style-loader',
        //如果需要，可以在 sass-loader 之前将 resolve-url-loader 链接进来
        use: ['css-loader', 'sass-loader']
    })
};
const babel = {
    test: /\.(jsx|js)$/,
    use: {
        loader: 'babel-loader',
        options: {
            presets: [
                "env", "react"
            ]
        }
    }
};
let arr = [css, img, html, sass, babel];
let str = ["css", "img", "html", "sass", "babel"];
module.exports = (...arg) => {
    let array = [];
    if (arg.length===0) {
        return {rules: arr};
    } else {
        for (let i = 0; i < arr.length; i++) {
            if (arg.indexOf(str[i]) !== -1) {
                array.push(arr[i]);
            }
        }
        return {rules: array};
    }
};