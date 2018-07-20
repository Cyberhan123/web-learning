//DOM
//console.log(window.screenX,window.screenY,window.innerHeight,window.innerWidth);
//弹窗
function outwindow() {
    var w = open('', '', 'width=300,height=200');
    w.moveBy(500, 300);
    window.close();

}

//恶搞
function loop_alert() {
    setInterval(window.alert("关掉我啊"),5000000);
}
//while (1)
loop_alert();
