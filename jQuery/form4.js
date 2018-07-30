$(function () {
    var $comment=$('#comment');
    $('.bigger').click(function () {
        //$comment.animate({ height : "+=50" },400);
        if(!$comment.is(":animated")){ //判断是否处于动画
            if( $comment.height() < 500 ){
                $comment.animate({ height : "+=50" },400); //重新设置高度，在原有的基础上加50
            }
        }
    });
    $('.smaller').click(function () {
        if(!$comment.is(":animated")){//判断是否处于动画
            if( $comment.height() > 50 ){
                $comment.animate({ height : "-=50" },400); //重新设置高度，在原有的基础上减50
            }
        }
    });
});