/**
 *                             _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                     佛祖保佑        永无BUG
 *            佛曰:
 *                   写字楼里写字间，写字间里程序员；
 *                   程序人员写程序，又拿程序换酒钱。
 *                   酒醒只在网上坐，酒醉还来网下眠；
 *                   酒醉酒醒日复日，网上网下年复年。
 *                   但愿老死电脑间，不愿鞠躬老板前；
 *                   奔驰宝马贵者趣，公交自行程序员。
 *                   别人笑我忒疯癫，我笑自己命太贱；
 *                   不见满街漂亮妹，哪个归得程序员？
 */
/**
 * @author Cyberhan
 * @email 255542417@qq.com
 * @description Cyberhan recode ,makes it more easyer to use
 */

const Cyentry = require("./webpack_config/entry.js");
const Cyoutput = require("./webpack_config/output.js");
const Cymodule = require("./webpack_config/module.js");
const Cyplugins = require("./webpack_config/plugins.js");
const CydevServer = require("./webpack_config/devServer.js");
// const glob = require('glob');
// const PurifyCSSPlugin = require("purifycss-webpack")
module.exports = {
    mode: "development",
    entry: Cyentry('./src/index.js', './src/print.js'),
    output: Cyoutput('http://localhost:8080/'),
    module: Cymodule(),
    plugins: Cyplugins(),
    devServer: CydevServer('localhost', '8080'),
};