package cn.hselfweb.awsomeservlet.Unit;

import cn.hselfweb.awsomeservlet.Servlet.ActionDispatcherInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


public class RequestMappingHandler {
    public void getRequestMapping(HttpServletRequest req, HttpServletResponse resp) {
        ClazzUnit clazzUnit = new ClazzUnit();
        Set<Class<?>> clazzs = clazzUnit.getClasses("cn.hselfweb.awsomeservlet.Action");
        if (clazzs == null) {
            return;
        }
        String uri = (String) req.getAttribute("java.servlet.include.request_uri");
        if (uri == null) {
            uri = req.getRequestURI();
        }
        for (Class<?> clazz : clazzs) {
            RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
            String path = requestMapping.value();
            if (clazz.isAnnotationPresent(RequestMapping.class) && path.equals(uri)) {
                try {
                    ActionDispatcherInterface actionDispatcherInterface = (ActionDispatcherInterface) clazz.newInstance();
                    actionDispatcherInterface.service(req, resp);
                } catch (InstantiationException | ServletException | IOException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                String cla = clazz.getSimpleName();
                System.out.println(cla + "." + path);
            }
        }
    }
}

