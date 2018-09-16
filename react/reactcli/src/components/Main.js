import React, {Component} from 'react';
import {BrowserRouter as Router,Route,Link} from 'react-router-dom'
import PageA from "./PageA";
import PageB from "./PageB";

class Main extends Component {
    render() {
        return (
            <div>
                main 主页面
                <Router>
                    <div>
                        跳转
                        <Link to='/a'>跳转A</Link><br/>
                        <Link to='/b'>跳转B</Link>
                        <Route path='/a' component={PageA}/>
                        <Route path='/b'  component={PageB}/>
                    </div>
                </Router>
            </div>
        );
    }
}

export default Main;