package cn.hselfweb.jsp.Actions;

import cn.hselfweb.jsp.VO.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ModifyShowAction implements Action {

	public  void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.getRequestDispatcher("/queryone.yjf").include(request, response);
		
		
		User vo = (User)request.getAttribute("currentUser");
		System.out.println(vo);
		request.getRequestDispatcher("/user.jsp").forward(request, response);
		



	}


	
	private void outputJiguan(PrintWriter out, User vo){
		out.println("����<select  name=\"jiguan\">");
		out.print("<option value=\"hubei\"   ");
//		if(vo.getJiguan().equals("hubei")){
//			out.print(" checked=\"checked\"");
//		}
		out.print(">����</option>");
		out.println();
		out.print("<option value=\"heilongjiang\" ");
//		if(vo.getJiguan().equals("heilongjiang")){
//			out.print(" checked=\"checked\"");
//		}
		out.print(">������</option>");
		out.println();
		out.print("<option value=\"jilin\"");
//		if(vo.getJiguan().equals("jilin")){
//			out.print(" checked=\"checked\" ");
//		}
		out.print(">����</option>");
		out.println();
		out.print("</select><br>");
	}


}
