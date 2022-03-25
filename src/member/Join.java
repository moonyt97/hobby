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
 * Servlet implementation class join
 */
@WebServlet("/Join.do")
public class Join extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberBean bean = new MemberBean();
		String memberID = request.getParameter("memberID");
		String memberPassword = request.getParameter("memberPassword");
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");

		
		bean.setMemberID(memberID);
		bean.setMemberPassword(memberPassword);
		bean.setMemberName(memberName);
		bean.setMemberPhone(memberPhone);

		MemberDAO mdao = new MemberDAO();
		
		int result = mdao.idCheck(memberID);
		if(result==1){
			request.setAttribute("joinResult", 1);
			RequestDispatcher dis = request.getRequestDispatcher("/");
			dis.forward(request, response);
		}
		mdao.joinMember(bean);
		response.sendRedirect("/");

	}

}
