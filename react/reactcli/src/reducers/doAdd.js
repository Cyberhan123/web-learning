import {combineReducers} from 'redux';

const count = (state = 0, action) => {
    console.log(state, action);
    switch (action.type) {
        case 'ADD_ACTION':
            return state + action.text;
        default :
            return state;
    }
};
const reducer = combineReducers({
    count,
});
export default reducer;
