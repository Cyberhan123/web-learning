const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const OptimizeCssAssetsPlugin = require('optimize-css-assets-webpack-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');

module.exports = {
    devtool: 'none',
    /*入口*/
    entry: {
        app: [
            // "@babel/polyfill",
            path.join(__dirname, '../src/index.js')
        ],
        // vendor: ['react', 'react-router-dom', 'redux', 'react-dom', 'react-redux']
    },
    mode: 'production',

    /*输出到dist目录，输出文件名字为bundle.js*/
    output: {
        //发布的基本路径
        publicPath: '/dist/',
        path: path.join(__dirname, '../dist'),
        filename: '[name].[hash].js',
        chunkFilename: '[name]_[chunkhash:8].js'
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                use: ['babel-loader?cacheDirectory=true'],
                include: path.join(__dirname, '../src')
            },
            {
                test: /\.css$/,
                use: ['style-loader',
                {
                    loader: 'css-loader',
                    options: {
                        modules: {
                            mode: 'local',
                            localIdentName: '[local][hash:base64:5]',
                            context: path.resolve(__dirname, 'src'),
                            hashPrefix: 'my-custom-hash',
                        },
                    }
                }
                    ,
                    "postcss-loader"],
            },
            {
                test: /\.(png|jpg|gif)$/,
                use: [
                    {
                        loader: 'url-loader',
                        options: {
                            limit: 8192
                        }
                    },

                ]
            },
        ]

    },

    plugins: [
        new CleanWebpackPlugin(),// 每次打包前清空
        new HtmlWebpackPlugin({
            filename: 'index.html',
            template: path.join(__dirname, '../public/index.html')
        }),
        // new MiniCssExtractPlugin({ // 压缩css
        //     filename: "[name].[contenthash].css",
        //     chunkFilename: "[id].[contenthash].css"
        // }),
        new OptimizeCssAssetsPlugin(),
    ],
    
    optimization: {
        splitChunks: {
            chunks: 'all'
        }
    }
};
