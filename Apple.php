<?php
/**
 * Created by PhpStorm.
 * User: Cybertron
 * Date: 2018/10/13
 * Time: 14:39
 */

class Apple
{
    var $color;
    function __construct($color = "red")
    {
        $this->color = $color;
    }
    function getColor(){
        return $this->color;
    }
}