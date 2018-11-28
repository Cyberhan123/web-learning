package cn.hselfweb.awsomeservlet.DAO;

import cn.hselfweb.awsomeservlet.VO.User;

import java.util.List;

public interface UserSQLInterface {
    /**
     * 函数queryAll返回数据库所有的User对象
     *
     * @return List<User>
     */
    List<User> queryAll();

    /**
     * 函数queryAll返回所有用户名是username的User对象
     *
     * @param name 传递User类的username
     * @return List<User>
     */
    List<User> queryByName(String name);

    /**
     * 函数queryById返回所有用户名是userID的User对象
     *
     * @param ID 传递User类的userID
     * @return User
     */
    User queryById(Long ID);

    /**
     * insert函数是插入一个User对象到数据库中
     *
     * @param user 传递单个的User类
     */
    void insert(User user);

    /**
     * update函数是更新一个User对象到数据库中
     *
     * @param user 传递单个的User类
     */
    void update(User user);

    /**
     * delete函数是删除一个数据库对应的User对象
     *
     * @param user
     */
    void delete(User user);
}
