/*
@author Cybertron
这是兼容性初始化
 */

//css
function getStyleSheet(elem, prop) {
    if (elem.currentStyle) {
        return elem.currentStyle[prop];
    } else {
        return getComputedStyle(elem, false)[prop];
    }
}
//得到下一个兄弟
function getNextSibling(elem) {
    do {
        elem = elem.nextSibling;
    } while (elem.nodeType !== 1 && elem != null);
    return elem;
}
//节点第一个孩子
function getFirstChild(elem) {
    //如果不是1就不是元素
    // var fC=elem.firstChild;
    // if (fC.nodeType!==1) {
    //     return getNextSibling(fC);
    // }
    // return fC;
    return elem.firstChild.nodeType!==1?getNextSibling(elem.firstChild):elem.firstChild;
}
