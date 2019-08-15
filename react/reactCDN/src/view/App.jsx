
const { BrowserRouter, Link } = ReactRouterDOM;
const Router = BrowserRouter;
import routes from '../router'
import RouteWithSubRoutes from "./../common/RouteWithSubRoutes.js";
import Navbar from './../components/NavBar.jsx';
import style from './../css/App.css';

export default class App extends React.Component {
  render() {
    return (
      <div className={style.App + " container"}>

        <Router>
          <Navbar>
            <div>
              <Link to="/tacos">啊们</Link>|
              <Link to="/sandwiches">啊前</Link>|
              <Link to="/sandwiches">一颗葡萄树</Link>
            </div>
          </Navbar>
          {routes.map((route, i) => (
            <RouteWithSubRoutes key={i} {...route} />
          ))}
        </Router>
      </div>
    );
  }
}
