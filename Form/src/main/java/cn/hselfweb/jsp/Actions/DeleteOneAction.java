package cn.hselfweb.jsp.Actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hselfweb.jsp.DAO.UserSQL;
import cn.hselfweb.jsp.Unit.RequestMap;
import cn.hselfweb.jsp.VO.User;

@RequestMap("/deleteOne")
public class DeleteOneAction implements Action {

	public void execute(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = arg0.getParameter("id");
		
		User user = new User();
		UserSQL userSQL = new UserSQL();
		user.setUserid(id);
		userSQL.delete(user);
		arg1.sendRedirect("/queryall");
	}

}
