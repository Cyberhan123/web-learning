$(function () {
    var co = $('#comment');
    $('.up').click(function () {
        console.log(111);
        if (!co.is(':animated'))
            co.animate({scrollTop: '-=50'}, 300);
    });
    $('.down').click(function () {
        if (!co.is(':animated'))
            co.animate({scrollTop: '+=50'}, 300);
    })
});