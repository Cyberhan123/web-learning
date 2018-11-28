package cn.hselfweb.awsomeservlet.Action;

import cn.hselfweb.awsomeservlet.DAO.UserSQL;
import cn.hselfweb.awsomeservlet.Servlet.ActionDispatcherInterface;
import cn.hselfweb.awsomeservlet.Unit.RequestMapping;
import cn.hselfweb.awsomeservlet.Unit.TemplateEngineUtil;
import cn.hselfweb.awsomeservlet.VO.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("/queryAll")
public class QueryAllAction implements ActionDispatcherInterface {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserSQL userSQL = new UserSQL();
        List<User> list = userSQL.queryAll();
        userSQL.close();
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("users", list);
        engine.process("queryAll.html", context, resp.getWriter());

    }
}
