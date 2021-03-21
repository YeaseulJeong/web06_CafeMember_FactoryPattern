package encore.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String execute(HttpServletRequest request, HttpServletResponse rewponse) throws SQLException ;

}
