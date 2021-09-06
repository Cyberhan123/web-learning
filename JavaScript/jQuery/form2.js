$(function () {
    $(":input").focus(function () {
        if (this.value === this.defaultValue)
            this.value = '';
        $(this).addClass('change');
    }).blur(function () {
        $(this).removeClass('change').val(this.value === "" ? this.defaultValue : this.value);
    });
});