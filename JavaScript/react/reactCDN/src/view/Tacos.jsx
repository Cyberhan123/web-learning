// import React from "react";
// import { Link } from "react-router-dom";
const { Link } = ReactRouterDOM;

import RouteWithSubRoutes from '../common/RouteWithSubRoutes'
export default
    function Tacos({ routes }) {
    return (
        <div>
            <h2>Tacos</h2>
            <ul>
                <li>
                    <Link to="/tacos/bus">啊西</Link>
                </li>
                <li>
                    <Link to="/tacos/cart">哈哈在笑他</Link>
                </li>
            </ul>

            {routes.map((route, i) => (
                <RouteWithSubRoutes key={i} {...route} />
            ))}
        </div>
    );
}



