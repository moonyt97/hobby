package hobby;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.HobbyBean;
import model.HobbyDAO;

/**
 * Servlet implementation class HobbyRegister
 */
@WebServlet("/HobbyRegister.do")
public class HobbyRegister extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		
		// 저장될 위치
		String realFolder = "";
		//최대 파일 크기
		int maxSize = 1024*1024*5;
		//한글처리
		String encType="UTF-8";
		String savefile = "img";
		ServletContext scontext = getServletContext();
		realFolder = scontext.getRealPath(savefile);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,new DefaultFileRenamePolicy());
		
		String hobbyTitle = multi.getParameter("hobbyTitle");
		String hobbyLo = multi.getParameter("hobbyLo");
		String hobbyCount = multi.getParameter("hobbyCount");
		String hobbyContent = multi.getParameter("hobbyContent");
		String hobbyImg = multi.getFilesystemName("hobbyImg");
		
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("loginMember");
		
		HobbyBean hbean = new HobbyBean();
		hbean.setHobbyTitle(hobbyTitle);
		hbean.setHobbyLo(hobbyLo);
		hbean.setHobbyCount(Integer.parseInt(hobbyCount));
		hbean.setHobbyContent(hobbyContent);
		hbean.setHobbyImg("/" + savefile + "/" + hobbyImg);
		hbean.setMemberID(memberID);
		
		HobbyDAO dao = new HobbyDAO();
		dao.insertHobby(hbean);
		
		response.sendRedirect("/Hobby.do");
	}

}
