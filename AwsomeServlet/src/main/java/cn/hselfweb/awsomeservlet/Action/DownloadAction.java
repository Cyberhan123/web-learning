package cn.hselfweb.awsomeservlet.Action;

import cn.hselfweb.awsomeservlet.Servlet.ActionDispatcherInterface;
import cn.hselfweb.awsomeservlet.Unit.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RequestMapping("/download")
public class DownloadAction implements ActionDispatcherInterface {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        String dir = System.getProperty("user.dir")+"\\src\\main\\webapp\\WEB-INF\\dir";
        String filepath = dir + "\\" + filename;
        resp.setContentType(req.getServletContext().getMimeType(filename));
        resp.setHeader("Content-Disposition", "attachment;filename=" + filename);
        InputStream in = new FileInputStream(filepath);
        OutputStream out = resp.getOutputStream();
        byte[] bs = new byte[1024];
        int size = 0;
        while ((size = in.read(bs)) > 0) {
            out.write(bs, 0, size);
        }
        in.close();
        out.close();
    }
}
