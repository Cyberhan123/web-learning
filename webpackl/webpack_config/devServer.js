const _dir = require('path');
module.exports=(host,port)=>{
    return{
        contentBase: _dir.resolve(__dirname, '../dist'),
        host: host,
        port: port,
        compress: true,
        hot: true,
        open: true
    };
};