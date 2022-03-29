package hobby;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.HobbyBean;
import model.HobbyDAO;

/**
 * Servlet implementation class HobbyUpdate
 */
@WebServlet("/HobbyUpdate.do")
public class HobbyUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String realFolder = "";
		int maxSize = 1024 * 1024 * 5;
		String encType = "UTF-8";
		String savefile = "img";
		ServletContext scontext = getServletContext();
		realFolder = scontext.getRealPath(savefile);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
				new DefaultFileRenamePolicy());

		HobbyDAO dao = new HobbyDAO();
		HobbyBean bean = new HobbyBean();
		

		String hobbyImg = "/" + savefile + "/" + multi.getFilesystemName("hobbyImg");
		int hobbyNo = Integer.parseInt(multi.getParameter("hobbyNo"));
		String hobbyTitle = multi.getParameter("hobbyTitle");
		String hobbyLo = multi.getParameter("hobbyLo");
		int hobbyCount=Integer.parseInt(multi.getParameter("hobbyCount"));
		String hobbyContent = multi.getParameter("hobbyContent");
		
		bean.setHobbyTitle(hobbyTitle);
		bean.setHobbyLo(hobbyLo);
		bean.setHobbyCount(hobbyCount);
		bean.setHobbyContent(hobbyContent);
		bean.setHobbyNo(hobbyNo);
		
		
		if (!hobbyImg.equals("/img/null")) {
			dao.updateImg(hobbyImg,hobbyNo);
		}else{
			dao.updateHobby(bean);
		}
		
		
		
		response.sendRedirect("/Hobby.do");
		
	}

}
