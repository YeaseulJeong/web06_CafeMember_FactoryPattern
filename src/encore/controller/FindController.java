package encore.controller;

import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.naming.ContextAccessController;

import servlet.model.MemberDAO;
import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller{   
	/*
	 * 1. 폼값 받아서  "model"
	 * 2. dao 리턴 _ 비즈니스 로직 호출 
	 * 3. return 값 바인딩
	 * 4. path....find_result.jsp
	 */
	
	public String execute (HttpServletRequest request, HttpServletResponse rewponse) throws SQLException{

		String id = request.getParameter("id");
		String path= "find_fail.jsp";   
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();   
		try {
			MemberVO vo = dao.findByIdMember(id);
			if(vo!=null) {
				request.setAttribute("vo", vo);  
				path = "find_ok.jsp";
			}else {
				
		}} catch(SQLException e) {
			
		}
		return path;
		
	}
	

}
