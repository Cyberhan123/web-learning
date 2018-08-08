import _ from 'lodash';
import printMe from './print.js';
// import css from './css/style.css';
//import sass from './css/common.scss';
function component() {
    var element = document.createElement('div');
   var btn = document.createElement('button');

    element.innerHTML = _.join(['Hello', 'webpack'], ' ');

   btn.innerHTML = 'Click me and check the console!';
   btn.onclick = printMe;

   element.appendChild(btn);

    return element;
  }

  document.body.appendChild(component());