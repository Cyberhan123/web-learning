$(function () {
    var imgs = '';
    var oNow = 0;
    var $big = $('#big');
    var $small = $('#small');
    for (var i = 0; i < 16; i++) {
        imgs += '<img src="' + (i + 1) + '.jpg">';
    }
    $small.html(imgs).on('tap', 'img', function () {
        $small.hide();
        oNow = $(this).index();
        $big.css('background-image', 'url("' + (oNow + 1) + '.jpg ")');
        $big.show();
    });
    $big.on('tap', function () {
        $big.hide();
        $small.show();

    }).on('swipeLeft', function () {
        ++oNow;
        if (oNow>15){
            oNow=0;
        }
        console.log(oNow);
        $big.css('background-image', 'url("' + (oNow + 1) + '.jpg ")');
    }).on('swipeRight', function () {
        --oNow;
        if (oNow<0){
            oNow=15;
        }
        $big.css('background-image', 'url("' + (oNow + 1) + '.jpg ")');
    })
});
