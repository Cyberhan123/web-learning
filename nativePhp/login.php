<?php
/**
 * Created by PhpStorm.
 * User: Cybertron
 * Date: 2018/10/14
 * Time: 10:25
 */
?>
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
<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST')
    if ($_POST['email'] == 'admin' and $_POST['password'] == '123') {
        echo '登录成功';
    } else {
        echo '登录失败';
    }
?>
<form action="login.php" method="post">
    邮箱： <input type="text" name="email">
    密码：<input type="password" name="password">
    <input type="submit" value="登录">
</form>
</body>
</html>
