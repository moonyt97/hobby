package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;
import model.MemberDAO;

/**
 * Servlet implementation class ProfileUpdateProc
 */
@WebServlet("/ProfileUpdateProc.do")
public class ProfileUpdateProc extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberID = request.getParameter("memberID");
		String memberPassword = request.getParameter("memberPassword");
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		
		MemberBean bean = new MemberBean();
		bean.setMemberID(memberID);
		bean.setMemberName(memberName);
		bean.setMemberPassword(memberPassword);
		bean.setMemberPhone(memberPhone);
		
		MemberDAO mdao = new MemberDAO();
		mdao.updateMember(bean);
		
		response.sendRedirect("/Profile.do");
		
	}

}
