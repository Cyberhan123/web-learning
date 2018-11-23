package cn.hselfweb.jsp.Actions;

import cn.hselfweb.jsp.VO.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SaveAction implements Action{
	
	
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int age = Integer.valueOf(request.getParameter("age"));
		String jiguan = request.getParameter("jiguan");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");
		String id = request.getParameter("id");
		
		User vo = new User();
//		vo.setUserName(username);
//		vo.setPassWord(password);
//		vo.setAge(age);
//		vo.setGender(gender);
//		vo.setJiguan(jiguan);
//		vo.setHobby(hobbies);
//		vo.setUserId(id);
//
//
//
//		UserService service =new UserServiceImpl();
//		service.save(vo);
		
		request.getServletContext().setAttribute("qwe", "123");
		
		response.sendRedirect("/queryall.yjf");
		
	}

}
