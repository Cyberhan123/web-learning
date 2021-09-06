package cn.hselfweb.jsp.Service;

import cn.hselfweb.jsp.DAO.UserSQL;
import cn.hselfweb.jsp.VO.User;

import java.util.List;

public class UserService implements UserServiceInterface {
    private UserSQL userSQL=new UserSQL();
    @Override
    public boolean login(User user) {
        List<User> users=userSQL.queryByName(user.getUsername());
        if (users.size()>0){
            for (User ignored :users){
                return ignored.getUsername().equals(user.getUsername()) && ignored.getPassword().equals(user.getPassword());
            }
        }
        else {
            return false;
        }
        return false;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void quit(User user) {

    }
}
