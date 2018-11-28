package cn.hselfweb.awsomeservlet.Server;

import cn.hselfweb.awsomeservlet.DAO.UserSQL;
import cn.hselfweb.awsomeservlet.VO.User;

import javax.servlet.http.Part;
import java.io.IOException;

public class UserService {
    public void save(User user) {
        UserSQL userSQL = new UserSQL();
        if (user.getId() == null || user.getId() == 0) {
            userSQL.insert(user);
        } else {
            userSQL.update(user);
        }
        userSQL.close();
    }

    public boolean saveFile(Part part) {
        if (part == null) {
            return false;
        }
        String fileName = part.getHeader("content-disposition");
        if (isBlank(fileName)) {
            return false;
        }
        fileName = substringBetween(fileName, "filename=\"", "\"");
        if (part.getSize() > 0) {
            try {
                part.write(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                return true;
            }
        } else {
            return false;
        }
        return true;
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0)
            return true;
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null)
            return null;
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1)
                return str.substring(start + open.length(), end);
        }
        return null;
    }

}

