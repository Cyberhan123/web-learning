package cn.hselfweb.jsp.Servlet;

import cn.hselfweb.jsp.DAO.UserSQL;
import cn.hselfweb.jsp.Service.UserService;
import cn.hselfweb.jsp.VO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passWorld = req.getParameter("password");
        User user = new User();
        user.setUsername(userName);
        user.setPassword(passWorld);

        UserService userService = new UserService();
        boolean success = userService.login(user);
       if (success){
           req.getRequestDispatcher("/index.jsp").forward(req,resp);
       }else {
           resp.sendRedirect("/Login.html");
       }
    }
}
