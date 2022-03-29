package hobby;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HobbyBean;
import model.HobbyDAO;

/**
 * Servlet implementation class HobbyDetail
 */
@WebServlet("/HobbyDetail.do")
public class HobbyDetail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int hobbyNo = Integer.parseInt(request.getParameter("hobbyNo"));
		
		HobbyDAO dao = new HobbyDAO();
		HobbyBean bean = new HobbyBean();
		bean = dao.getHobbyDetail(hobbyNo);
		
		request.setAttribute("bean", bean);
		RequestDispatcher dis = request.getRequestDispatcher("/hobby/hobbyDetail.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
