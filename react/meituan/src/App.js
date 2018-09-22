//{Component}是解构
import React, {Component} from 'react';
import add from './actions/add';
// import store from './store';
import {connect} from 'react-redux';

const mapStateToProps = (state) => {
    return{
        count:state.count,
    }
};
const mapDispatchToProps=(dispatch)=>{
    return{
        add:(num)=>dispatch(add(num))
    }
};


class App extends Component {
    // static addHandle(num) {
    //     store.dispatch(add(num));
    // }
    render() {
        return (
            <div className="App">
                <h1>{this.props.count}</h1>
                <button onClick={
                    ()=>{
                        this.props.add(2)
                    }
                }/*onClick={App.addHandle.bind(this,this.props.count)}*/>加</button>
            </div>
        );
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(App);
