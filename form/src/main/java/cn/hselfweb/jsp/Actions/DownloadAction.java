package cn.hselfweb.jsp.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownloadAction implements Action{
	
	
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename = request.getParameter("filename");
		String dir = request.getServletContext().getRealPath("")+"uploaddir";
		
		String filepath =  dir + "/" + filename;
		
		response.setContentType(request.getServletContext().getMimeType(filename));
		
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		InputStream in = new FileInputStream(filepath);
		OutputStream out = response.getOutputStream(); 
		byte[] bs = new byte[1024];
		int size = 0;
		while((size = in.read(bs))> 0){
			out.write(bs, 0, size);
		}
		in.close();
		out.close();
		
	
	}
	

//	@Override
//	protected void service(HttpServletRequest request, 
//			HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		int min = Integer.valueOf(request.getParameter("min"));
//		int max = Integer.valueOf(request.getParameter("max"));
//		
//		response.setContentType(getServletContext().getMimeType("1.csv"));
//		
//		response.setHeader("Content-Disposition", "attachment;filename="+"1.csv");
//		
//		OutputStream out = response.getOutputStream(); 
//		PrintStream ps = new PrintStream(out);
//		
//		
//		UserDao dao = new UserDaoImpl();	
//		List<UserVO> users = dao.queryByAge(min, max);
//		for(UserVO vo : users){
//			ps.println(vo.toCSV());
//			
//		}
//		ps.close();
//		
//		
//	}

}
