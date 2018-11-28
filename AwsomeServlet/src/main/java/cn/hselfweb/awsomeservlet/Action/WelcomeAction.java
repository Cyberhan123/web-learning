package cn.hselfweb.awsomeservlet.Action;

import cn.hselfweb.awsomeservlet.Servlet.ActionDispatcherInterface;
import cn.hselfweb.awsomeservlet.Unit.RequestMapping;
import cn.hselfweb.awsomeservlet.Unit.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/")
public class WelcomeAction implements ActionDispatcherInterface {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("recipient", "World");
        engine.process("index.html", context, resp.getWriter());
    }
}
