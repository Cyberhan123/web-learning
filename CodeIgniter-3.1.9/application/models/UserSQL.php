<?php
/**
 * Created by PhpStorm.
 * User: Cybertron
 * Date: 2018/10/20
 * Time: 14:52
 */

class UserSQL extends CI_Model
{
    public function __construct()
    {
        $this->load->database();
    }

    public function save($username, $password)
    {
        $data = array(
            'username' => $username,
            'password' => $password,
        );


    }
}