package cn.hselfweb.awsomeservlet.Servlet;

import cn.hselfweb.awsomeservlet.Action.WelcomeAction;
import cn.hselfweb.awsomeservlet.Unit.RequestMapping;
import cn.hselfweb.awsomeservlet.Unit.RequestMappingHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDispatcher",urlPatterns = "/*")
public class ServletDispatcher extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
       //解决中文乱码
        resp.setContentType("text/html;charset=UTF-8");
        RequestMappingHandler requestMappingHandler=new RequestMappingHandler();
        requestMappingHandler.getRequestMapping(req, resp);
    }
}
