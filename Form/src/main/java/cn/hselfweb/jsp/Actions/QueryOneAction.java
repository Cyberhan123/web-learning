package cn.hselfweb.jsp.Actions;

import cn.hselfweb.jsp.DAO.UserSQL;
import cn.hselfweb.jsp.VO.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class QueryOneAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("id");
		UserSQL dao = new UserSQL();
		User vo = dao.queryById(userid);
		
		request.setAttribute("currentUser", vo);
		
	}
	
	
	

}
