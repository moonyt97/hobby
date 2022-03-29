package hobby;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HobbyDAO;

/**
 * Servlet implementation class HobbyDelete
 */
@WebServlet("/HobbyDelete.do")
public class HobbyDelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hobbyNo = Integer.parseInt(request.getParameter("hobbyNo"));
		
		HobbyDAO dao = new HobbyDAO();
		dao.deleteHobby(hobbyNo);
		
		response.sendRedirect("/Hobby.do");
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
