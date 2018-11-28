package cn.hselfweb.awsomeservlet.Action;

import cn.hselfweb.awsomeservlet.Servlet.ActionDispatcherInterface;
import cn.hselfweb.awsomeservlet.Unit.RequestMapping;
import cn.hselfweb.awsomeservlet.VO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequestMapping("/modifyShow")
public class ModifyShowAction implements ActionDispatcherInterface {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/queryOne").include(req, resp);
//        User user = (User)req.getAttribute("currentUser");
//        System.out.println(user);
        req.getRequestDispatcher("/save").forward(req, resp);
    }
}
