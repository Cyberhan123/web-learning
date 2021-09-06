package cn.hselfweb.jsp.Servlet;

import cn.hselfweb.jsp.Actions.Action;
import cn.hselfweb.jsp.Unit.classMapByAnnotation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


public class CentralServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Class<?>> classes = classMapByAnnotation.getClasses("cn.hselfweb.jsp");
        Action action;
        for (Class<?> clazz : classes) {
            try {
                action = (Action) clazz.newInstance();
                action.execute(req, resp);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }


}