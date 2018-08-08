const _dir = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const ExtractTextPlugin = require("extract-text-webpack-plugin");
module.exports = {
    mode: "development",
    entry: {
        //同级目录必须要./
        index: './src/index.js',
        print: './src/print.js'
    },
    output: {
        path: _dir.resolve(__dirname, 'dist'),
        filename: '[name].bundle.js',
        publicPath: 'http://localhost:8080/'
    },
    module: {
        rules:
            [
                {
                    test: /\.css$/,
                    //这两个不能写反
                    //use:['style-loader','css-loader']
                    //额外加载
                    use: ExtractTextPlugin.extract({
                        fallback: "style-loader",
                        use: "css-loader"
                    })
                },
                {
                    test: /\.(png|jpg|gif)/i,
                    use: [{
                        loader: 'url-loader',
                        options: {
                            limit: 500,
                            outputPath: 'images/'
                        }
                    }]
                },
                {
                    test: /\.(htm|html)$/i,
                    loader: 'html-withimg-loader'
                }, {
                test: /\.scss/,
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
                use: ExtractTextPlugin.extract({
                    use: [{
                        loader: "css-loader"
                    },
                        {
                            loader: "sass-loader"
                        }],
                    fallback: "style-loader"
                })
            }
            ]
    },
    plugins: [
        // new CleanWebpackPlugin(['dist']),
        new webpack.HotModuleReplacementPlugin(
        ),
        new HtmlWebpackPlugin(
            {
                title: 'HELLO',
                minify: {
                    removeAttributeQuotes: true
                },
                //hash: true,
                template: './src/index.html',
                filename: 'index.html',
                //hash: true
            }
        ),
        new ExtractTextPlugin("./src/css/style.css")
    ],
    devServer: {
        contentBase: _dir.resolve(__dirname, 'dist'),
        host: 'localhost',
        port: '8080',
        compress: true,
        hot: true,
        open: true
    }

};