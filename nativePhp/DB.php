<?php
/**
 * Created by PhpStorm.
 * User: Cybertron
 * Date: 2018/10/14
 * Time: 16:10
 */

$connect = mysqli_connect("localhost", "root", "", "test");
$sql="select * from userdata";
$result=mysqli_query($connect,$sql);
//var_dump($result);
$arr=array();//定义空数组
while($row =mysqli_fetch_array($result)){
    var_dump($row);
    //array_push(要存入的数组，要存的值)
   // array_push($arr,$row);
}
//PDO
mysqli_close($connect);