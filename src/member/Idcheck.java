package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

@WebServlet("/Idcheck.do")
public class Idcheck extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberID = request.getParameter("memberID");
		
		MemberDAO mdao = new MemberDAO();
		int result = mdao.idCheck(memberID);
		
		request.setAttribute("memberID", memberID);
		request.setAttribute("result", result);
		
		RequestDispatcher dis = request.getRequestDispatcher("member/Idcheck.jsp");
		dis.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
