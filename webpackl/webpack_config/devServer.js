/**
 *
 * @author Cyberhan
 *
 */
const _dir = require('path');
/**
 * @param host
 * @param port
 * @returns {{contentBase: *, host: *, port: *, compress: boolean, hot: boolean, open: boolean}}
 */
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