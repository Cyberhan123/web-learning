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

@RequestMapping("/queryOne")
public class QueryOneAction implements ActionDispatcherInterface {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userid = Long.valueOf(req.getParameter("id"));
        UserSQL userSQL = new UserSQL();
        User user = userSQL.queryById(userid);
        userSQL.close();
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("user", user);
        engine.process("queryOne.html", context, resp.getWriter());
    }
}
