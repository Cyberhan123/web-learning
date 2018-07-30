$(function () {
    var size=80;
    $('.bigger').click(function () {
        size+=30;
        $('#comment').css('height',size);
    });
    $('.smaller').click(function () {
        if (size>=80){
            size-=30;
        }
        console.log(size);
        $('#comment').css('height',size);
    })

});