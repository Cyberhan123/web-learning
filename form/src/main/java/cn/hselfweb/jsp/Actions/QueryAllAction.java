package cn.hselfweb.jsp.Actions;

import cn.hselfweb.jsp.DAO.UserSQL;
import cn.hselfweb.jsp.VO.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class QueryAllAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		UserSQL dao = new UserSQL();
		
		List<User> list = dao.queryAll();
		
		request.setAttribute("allstu", list);
		
		request.getRequestDispatcher("/listall2.jsp").forward(request, response);
	
	
	}
	
	

}
