package cn.hselfweb.awsomeservlet.Action;

import cn.hselfweb.awsomeservlet.Server.UserService;
import cn.hselfweb.awsomeservlet.Servlet.ActionDispatcherInterface;
import cn.hselfweb.awsomeservlet.Unit.RequestMapping;
import cn.hselfweb.awsomeservlet.VO.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@RequestMapping("/save")
@MultipartConfig(location = "C:\\Users\\Cybertron\\IdeaProjects\\web-learning\\AwsomeServlet\\src\\main\\webapp\\WEB-INF\\dir", maxFileSize = 1024 * 1024 * 10)
public class SaveAction implements ActionDispatcherInterface {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String sex = req.getParameter("sex");
        Long id = Long.valueOf(req.getParameter("id"));
        User user = new User(id, username, password, phone, sex);
        UserService service = new UserService();
        Part part = req.getPart("filename");
        service.saveFile(part);
        service.save(user);
        resp.sendRedirect("/queryAll");
    }
}
