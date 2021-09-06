import Sandwiches from './view/Sandwiches.jsx';
import Bus from './view/Bus.jsx';
import Cart from './view/Cart.jsx';
import Tacos from './view/Tacos.jsx';
const routes = [
    {
        path: "/sandwiches",
        component: Sandwiches
    },
    {
        path: "/tacos",
        component: Tacos,
        routes: [
            {
                path: "/tacos/bus",
                component: Bus
            },
            {
                path: "/tacos/cart",
                component: Cart
            }
        ]
    }
];
export default routes;
