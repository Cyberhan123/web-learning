package cn.hselfweb.awsomeservlet.Action;

import cn.hselfweb.awsomeservlet.DAO.UserSQL;
import cn.hselfweb.awsomeservlet.Servlet.ActionDispatcherInterface;
import cn.hselfweb.awsomeservlet.Unit.RequestMapping;
import cn.hselfweb.awsomeservlet.VO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/deleteOne")
public class DeleteOneAction implements ActionDispatcherInterface {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        UserSQL userSQL = new UserSQL();
        User user = new User();
        user.setId(id);
        userSQL.delete(user);
        userSQL.close();
        resp.sendRedirect("/queryall");
    }
}
