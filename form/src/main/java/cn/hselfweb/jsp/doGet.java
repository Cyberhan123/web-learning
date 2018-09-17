package main.java.cn.hselfweb.jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class doGet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
        String userName = req.getParameter("username");
        System.out.println(userName);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if (userName != null && userName != "") {
            out.print("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>表单</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "成了安排上了:" + userName +
                    "</body>\n" +
                    "</html>");
            out.close();
        } else {
            out.println("凉凉");
        }
//        单行输出
//        out.println();
    }


}
