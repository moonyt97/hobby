package participate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ParticipateDAO;

/**
 * Servlet implementation class ParticipateDelete
 */
@WebServlet("/ParticipateDelete.do")
public class ParticipateDelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		int hobbyNo = Integer.parseInt(request.getParameter("hobbyNo"));
		String loginMember = (String) session.getAttribute("loginMember");

		ParticipateDAO pdao = new ParticipateDAO();
		pdao.deleteParticipate(hobbyNo, loginMember);

		request.setAttribute("hobbyNo", hobbyNo);

		RequestDispatcher dis = request.getRequestDispatcher("/HobbyDetail.do");
		dis.forward(request, response);

	}
}
