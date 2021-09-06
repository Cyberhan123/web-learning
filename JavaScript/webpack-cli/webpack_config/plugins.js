/**
 *
 * @author Cyberhan
 */
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const ExtractTextPlugin = require("extract-text-webpack-plugin");
const CopyWebpackPlugin = require("copy-webpack-plugin");
//let CleanDist = new CleanWebpackPlugin(['dist']);
let HtmlPlugin = new HtmlWebpackPlugin({
    title: 'APP',
    minify: {
        removeAttributeQuotes: true
    },
    template: './src/index.html',
    filename: 'index.html',
    hash: true
});
let HotModule = new webpack.HotModuleReplacementPlugin();
let CssOutPutPath = new ExtractTextPlugin("./src/css/[name].css");
let AuthorMessage = new webpack.BannerPlugin('Cyberhan plugin 2018/8/8 @webpack 4.16.5');
let ReadMe = new CopyWebpackPlugin([
    {
        from: __dirname + '/../src/public',
        to: '/public'
    }
]);
let Production = new webpack.ProvidePlugin({
    $: "jquery"
});
/**
 * @returns {*[]}
 */
module.exports = () => {
    return [HtmlPlugin,HotModule,CssOutPutPath,AuthorMessage,Production]
};
