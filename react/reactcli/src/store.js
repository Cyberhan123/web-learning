/**
 * store .js
 * @export store 暴露 store
 * 用于存储全局数据
 */

import {createStore} from 'redux';
import reducer from './reducers/doAdd'
const inintialState = {
    count: 0
};

const store = createStore(reducer, inintialState);
export default store;
