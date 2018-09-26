package cn.hselfweb.jsp.Servlet;

import cn.hselfweb.jsp.DAO.UserSQL;
import cn.hselfweb.jsp.VO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryAllServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserSQL userSQL=new UserSQL();
        List<User> users=userSQL.queryAll();
        userSQL.close();

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        for(User user:users){
            out.println(user.getUserid());
            out.println(user.getUsername());
            out.println(user.getSex());
            out.println(user.getAgree());
            out.println(user.getPassword());
        }

    }
}
