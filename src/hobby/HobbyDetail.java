package hobby;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HobbyBean;
import model.HobbyDAO;
import model.MemberBean;
import model.ParticipateDAO;

/**
 * Servlet implementation class HobbyDetail
 */
@WebServlet("/HobbyDetail.do")
public class HobbyDetail extends HttpServlet {
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
		String loginMember = (String) session.getAttribute("loginMember");
		
		int hobbyNo = Integer.parseInt(request.getParameter("hobbyNo"));
		HobbyDAO dao = new HobbyDAO();
		HobbyBean bean = new HobbyBean();
		ArrayList<MemberBean>mlist = new ArrayList<>();
		bean = dao.getHobbyDetail(hobbyNo);
		mlist = dao.getParticipateMember(hobbyNo);
		
		
		ParticipateDAO pdao= new ParticipateDAO();
		boolean isParticipate = pdao.isParticipate(hobbyNo,loginMember);
		int participateCount = pdao.participateCount(hobbyNo);
		
		request.setAttribute("isParticipate",isParticipate);
		request.setAttribute("participateCount", participateCount);
		request.setAttribute("bean", bean);
		request.setAttribute("mlist", mlist);
		RequestDispatcher dis = request.getRequestDispatcher("/hobby/hobbyDetail.jsp");
		dis.forward(request, response);
	}
}
