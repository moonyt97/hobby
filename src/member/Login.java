package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.do")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberID = request.getParameter("memberID");
		String memberPassword = request.getParameter("memberPassword");
		
		MemberDAO mdao = new MemberDAO();
		int result = mdao.memberLogin(memberID, memberPassword);
		if(result==1){
			HttpSession session =request.getSession();
			session.setAttribute("loginMember", memberID);
			RequestDispatcher dis = request.getRequestDispatcher("/");
			dis.forward(request, response);
		}else{
			request.setAttribute("loginResult", result);
			RequestDispatcher dis = request.getRequestDispatcher("/");
			dis.forward(request, response);
		}
	}

}
