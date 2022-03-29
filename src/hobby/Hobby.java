package hobby;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.RecoveredRequiresStatement;

import model.HobbyBean;
import model.HobbyDAO;

/**
 * Servlet implementation class Hobby
 */
@WebServlet("/Hobby.do")
public class Hobby extends HttpServlet {
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
		// 화면에 보여질 게시글의 갯수
		int pageSize = 8;
		// 현재 보여지고 있는 페이지의 넘버값을 읽어드림
		String pageNum = request.getParameter("pageNum");
		// null처리
		if (pageNum == null) {
			pageNum = "1";
		}
		// 전체 글의 개수를 파악
		int count = 0;

		// 현재 보여지고 있는 페이지 문자를 숫자로 형변환
		int currentPage = Integer.parseInt(pageNum);
		// 전체 게시글의 갯수를 가져와야 함.
		HobbyDAO hdao = new HobbyDAO();
		count = hdao.getAllCount();

		// 현재 보여질 페이지 시작 번호를 설정
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;

		ArrayList<HobbyBean> beans = new ArrayList<>();

		int result = 0;
		String hobbyLo = request.getParameter("hobbyLo");
		String keyword = request.getParameter("keyword");
		if ((hobbyLo == null && keyword == null) || (hobbyLo.equals("0") && keyword.equals(""))) {
			beans = hdao.getAllHobby(startRow, endRow);
		} else if (hobbyLo != null && (keyword == null || keyword.equals(""))) {
			beans = hdao.getLocationHobby(hobbyLo, startRow, endRow);
			count = hdao.getLocationCount(hobbyLo);
		} else if ((hobbyLo == null || hobbyLo.equals("0")) && keyword != null) {
			beans = hdao.getKeywordHobby(keyword.trim(), startRow, endRow);
			count = hdao.getKeywordCount(keyword.trim());
		} else {
			beans = hdao.getKeywordLoHobby(hobbyLo, keyword.trim(), startRow, endRow);
			count = hdao.getKeywordLoCount(hobbyLo,keyword.trim());
		}
		if (beans.size() == 0) {
			request.setAttribute("result", result);
		}
		request.setAttribute("beans", beans);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);

		RequestDispatcher dis = request.getRequestDispatcher("/hobby/hobby.jsp");
		dis.forward(request, response);
	}

}
