$(function () {
    $('#add').click(function () {
        $('#select1 option:selected').appendTo('#select2');
    });
    $('#add_all').click(function () {
        $('#select1 option').appendTo('#select2');
    });
    $('#remove').click(function () {
        $('#select2 option:selected').appendTo('#select1');
    });
    $('#remove_all').click(function () {
        $('#select2 option').appendTo('#select1');
    });
});