package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Session;

import encore.controller.Controller;
import encore.controller.ControllerFactory;
import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

/**
 *  <servlet>
    <servlet-name>RegisterServlet</servlet-name>
    <servlet-class>servlet.controller.DispatcherServlet (FQCN)  </servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>DispatcherServlet</servlet-name>
    <url-pattern>/front.do</url-pattern>
  </servlet-mapping>
  
  
 */
@WebServlet("/front.do")

// 비즈니스 로직 하나 처리하자고 용량이 큰 서블릿 하나를 각각 계속 만드는 건 비효율적이다 
//그래서 그전의 각각의 서블릿들에 해당하는 메서드들을 하나의 서블릿안에 구현하면 됨
// DispatcherServlet 은 command 를 먼저 확인해서 어떤 요청을 요구하는건지 if else 로 판단을 제일먼저 해줘야


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DispatcherServlet() {
        super();
        // Servlet은 서버가 만든다  그래서 생성자가 있다 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성..
		
		//1. command 값 받는다
		String command = request.getParameter("command");
		String path = "erro.jsp";
		
		//2. Factory 의 메서드 호출해서 Controller 리턴 받는다
		Controller controller = ControllerFactory.getInstance().createController(command);
		
		//3. Controller 의 메서드 호출해서 패스를 리턴 받는다 
		try {
			path = controller.execute(request, response);
			
		}catch(SQLException e) {
			
		}
		
		//4. 네비게이션
		//각각의 Controller 에서 setAttribute 를 한 것에 대한 것 
		request.getRequestDispatcher(path).forward(request, response);
	}
	
}
