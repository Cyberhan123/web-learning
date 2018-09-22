import React, {Component} from 'react';
import {BrowserRouter as Router, Link, Route, Switch} from 'react-router-dom'
import PageA from "./PageA";
import PageB from "./PageB";

class Main extends Component {
    render() {
        return (
            <div>
                x<Router>
                    <div>
                        <Link to='/a'>跳转A</Link>/
                        <Link to='/b'>跳转B</Link>
                    </div>
                </Router>
                {/*main 主页面*/}
                <Router>
                    <div>
                        <Link to='/a/5'>跳转A</Link>/
                        <Link to='/b'>跳转B</Link>/
                        main 主页面
                        <Switch>
                            <Route path='/a/:id' component={PageA}/>
                            <Route path='/b' component={PageB}/>
                            <Route path='/c' render={
                                ()=>{
                                    return <h1>111</h1>
                                }
                            }/>
                            <Route path='/b/aaa' chirldren={PageB}/>
                        </Switch>
                    </div>
                </Router>
            </div>
        );
    }
}

export default Main;