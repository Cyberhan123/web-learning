$(function () {
    var us=$('#username');
    var pd=$('#pwd');
    var mg=$('#msg');
    function changeColor(tag) {
        tag.focus(function () {
            init();
            $(this).addClass('change');
        });
    }
    function init(){
        us.removeClass('change');
        pd.removeClass('change');
        mg.removeClass('change');
    }
    changeColor(us);
    changeColor(pd);
    changeColor(mg);
});
//更简单的方法
// $(function(){
//     $(":input").focus(function(){//$("input, textarea")
//         $(this).addClass("focus");
//         //this.className = "focus";
//     }).blur(function(){
//         $(this).removeClass("focus");
//     });
// })