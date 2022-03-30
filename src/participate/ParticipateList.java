package participate;

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

/**
 * Servlet implementation class ParticipateList
 */
@WebServlet("/ParticipateList.do")
public class ParticipateList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("loginMember");
		
		HobbyDAO hdao = new HobbyDAO();
		ArrayList<HobbyBean> lists = hdao.participateList(memberID);
		
		request.setAttribute("lists", lists);
		RequestDispatcher dis = request.getRequestDispatcher("/member/participateList.jsp");
		dis.forward(request, response);
		
		
	}
	
}
