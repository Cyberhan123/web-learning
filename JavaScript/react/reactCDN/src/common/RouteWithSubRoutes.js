// import React from "react";
// import {Route} from "react-router-dom";
const { Route } = ReactRouterDOM
/**
 * 接受router 对象 对 对象进行映射
 * @param {Object} route 
 */
export default function RouteWithSubRoutes(route) {
  return (
    <Route
      path={route.path}
      render={props => (
        // pass the sub-routes down to keep nesting
        <route.component {...props} routes={route.routes} />
      )}
    />
  );
}