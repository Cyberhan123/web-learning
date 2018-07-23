function getStyleSheet(elem,prop) {
    if (elem.currentStyle) {
        return elem.currentStyle[prop];
    }else{
        return getComputedStyle(elem,false)[prop];
    }
}