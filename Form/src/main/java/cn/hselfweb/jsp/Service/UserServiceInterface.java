package cn.hselfweb.jsp.Service;

import cn.hselfweb.jsp.VO.User;

public interface UserServiceInterface {
    boolean login(User user);
    void save(User user);
    void quit(User user);
}
