const _dir = require('path');
/**
 * @param publicPath
 * @returns {{path: *, filename: string, publicPath: *}}
 */
module.exports=(publicPath)=>{
    return{
        path: _dir.resolve(__dirname, '../dist'),
        filename: '[name].bundle.js',
        publicPath: publicPath,
    }
};