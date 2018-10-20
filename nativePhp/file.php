<?php
/**
 * Created by PhpStorm.
 * User: Cybertron
 * Date: 2018/10/14
 * Time: 15:09
 */
?>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>

<form action="upload.php" method="post"
      enctype="multipart/form-data">
          Filename: <input type="file" name="file" id="file" />
    <br />
    <input type="submit" name="submit" value="Submit" />
</form>

</body>
</html>