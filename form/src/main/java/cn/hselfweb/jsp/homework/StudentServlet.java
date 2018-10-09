package cn.hselfweb.jsp.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/queryone").include(req, resp);


        Student student = (Student) req.getAttribute("currentUser");
        System.out.println(student);

        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>all user</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form  action=\"/save\"  method=\"post\" >");
        out.println("<input type=\"hidden\" name=\"id\" value=\""+student.getUserid()+"\">");
        out.println("用户名<input type = \"text\" name = \"username\"  value=\""+student.getUsername()+"\"><br>");
        out.println("密码<input type = \"password\" name = \"password\"  value=\""+student.getPassword()+"\"><br>");
        out.println("年龄<input type = \"text\" name = \"age\"  value=\""+student.getAgree()+"\"><br>");
        out.println("性别<input type=\"radio\" name=\"gender\" value=\"F\">女");
        out.println("<input type=\"radio\" name=\"gender\" value=\"M\">男<br>");
        out.println("<input type = \"submit\" value=\"提交\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
