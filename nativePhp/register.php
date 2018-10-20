<?php
/**
 * Created by PhpStorm.
 * User: Cybertron
 * Date: 2018/10/14
 * Time: 13:39
 */ ?>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div id="echo"></div>
邮箱：
<input type="text" name="email"><br/>
密码：
<input type="password" name="password">
<button id="reg-btn">注册</button>
<script src="jquery-3.3.1.js"></script>
<script>
    $(function () {
        $('#reg-btn').click(function () {
            var email = $('input[name="email"]').val();
            var password = $('input[name="password"]').val();
            console.log(email);
            $.get('regServer.php', {
                email: email,
                password: password
            }, function (data) {
                $('#echo').html(data)
            }, 'text');
        })
    })


</script>
</body>
</html>
