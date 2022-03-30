package participate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HobbyBean;
import model.ParticipateDAO;

/**
 * Servlet implementation class Participate
 */
@WebServlet("/Participate.do")
public class Participate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		String memberID = (String) session.getAttribute("loginMember");
		int hobbyNo = Integer.parseInt(request.getParameter("hobbyNo"));
		
		ParticipateDAO dao = new ParticipateDAO();
		dao.participateInsert(memberID,hobbyNo);
		
		request.setAttribute("hobbyNo", hobbyNo);
		
		RequestDispatcher dis = request.getRequestDispatcher("/HobbyDetail.do");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
