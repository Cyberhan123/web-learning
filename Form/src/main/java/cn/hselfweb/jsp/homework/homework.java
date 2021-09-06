package cn.hselfweb.jsp.homework;

import cn.hselfweb.jsp.DAO.UserSQL;
import cn.hselfweb.jsp.VO.User;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class homework extends HttpServlet {
    @Override
    protected void service(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException {
        String username = rq.getParameter("username");
        String password = rq.getParameter("password");
        String sex = rq.getParameter("sex");
        String agree = rq.getParameter("choose");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setSex(sex);
        user.setAgree(agree);
        UserSQL userSQL = new UserSQL();
        userSQL.insert(user);
        //页面跳转
        //rsp.sendRedirect("/xxx");
        //跳转
        rq.getRequestDispatcher("/xxx").forward(rq,rsp);
//        rsp.setContentType("text/html;charset=utf-8");
//        PrintWriter out = rsp.getWriter();
//        out.write("<!DOCTYPE html>\n" +
//                "<html lang=\"en\">\n" +
//                "\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <title>Title</title>\n" +
//                "</head>\n" +
//                "\n" +
//                "<body>\n" +
//                "    <div class=\"container\">\n" +
//                "\n" +
//                "        <h1>提交成功</h1>\n" +
//                "        用户名: 密码: 下拉选择: 文本: 单选：\n" +
//                "    </div>\n" +
//                "</body>\n" +
//                "\n" +
//                "</html>");
    }
}
