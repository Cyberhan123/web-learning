package cn.hselfweb.jsp.homework;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StudentEditServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String value = (String)req.getSession().getAttribute("qwe");
        String value = (String)req.getServletContext().getAttribute("qwe");

        System.out.println(value);

        StudentSQL studentSQL = new StudentSQL();

        List<Student> list = studentSQL.queryAll();


        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>all user</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<td>用户名</td>");
        out.println("<td>年龄</td>");
        out.println("<td>籍贯</td>");
        out.println("<td>爱好</td>");
        out.println("<td>性别</td>");
        out.println("<td>操作</td>");
        out.println("</tr>");
        for(Student student : list){
            out.println("<tr>");
            out.println("<td>"+student.getUsername()+"</td>");
            out.println("<td>"+student.getPassword()+"</td>");
            out.println("<td>"+student.getAgree()+"</td>");
            out.println("<td>"+student.getSex()+"</td>");
            out.println("<td>"+student.getStudentClass()+"</td>");
            out.println("<td> <a href=\"/studentedit?id="+student.getUserid()+"\">修改</a>"
                    + "||<a href=\"/studentedit?id="+student.getUserid()+"\">删除</a>"
                    + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
        out.close();


    }
}
