package encore.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class IdCheckController implements Controller {
	
	public String execute (HttpServletRequest request, HttpServletResponse rewponse) throws SQLException{
 
		//예전의 FindServlet
		//1. 폼값받아서
		String id = request.getParameter("id");	
		String path = "idcheck.jsp";
		try {
			boolean flag=MemberDAOImpl.getInstance().idExist(id);			
			request.setAttribute("flag", flag);
			
		}catch(SQLException e) {
			System.out.println(e);
		}			
		return path;

}
}
