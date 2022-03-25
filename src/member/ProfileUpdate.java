package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.MemberDAO;

/**
 * Servlet implementation class ProfileUpdate
 */
@WebServlet("/ProfileUpdate.do")
public class ProfileUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDAO mdao = new MemberDAO();
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("loginMember");
		MemberBean bean = mdao.getMember(memberID);
		String memberPassword = bean.getMemberPassword();

		String inputPassword = request.getParameter("memberPassword");

		if (memberPassword.equals(inputPassword)) {
			request.setAttribute("bean", bean);

			RequestDispatcher dis = request.getRequestDispatcher("/member/profileUpdateForm.jsp");
			dis.forward(request, response);
		}else{
			request.setAttribute("result", "0");
			
			RequestDispatcher dis = request.getRequestDispatcher("/member/profileUpdateForm.jsp");
			dis.forward(request, response);
		}

	}

}
