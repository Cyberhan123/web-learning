import {combineReducers} from 'redux';

const doAdd=(count,action)=>{
    console.log(count,action);
    switch (action.type) {
        case 'ADD_ACTION':
            return count+1;
        default :
            return count;

    }
    return state;
};
const reducer=combineReducers({
    doAdd,
});
export default reducer;
