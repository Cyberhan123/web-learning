//{Component}是解构
import React, {Component} from 'react';
import add from './actions/add';
import store from './store';

class App extends Component {
     static addHandle(){
        store.dispatch(add());
    }
    render() {
        return (
            <div className="App">
                <h1>11</h1>
                <button onClick={App.addHandle.bind(this)}>加</button>
            </div>
        );
    }
}

export default App;
