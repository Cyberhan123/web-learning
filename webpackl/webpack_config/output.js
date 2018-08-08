const _dir = require('path');
module.exports=(publicPath)=>{
    return{
        path: _dir.resolve(__dirname, '../dist'),
        filename: '[name].bundle.js',
        publicPath: publicPath,
    }
};