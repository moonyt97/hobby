package hobby;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HobbyBean;
import model.HobbyDAO;

/**
 * Servlet implementation class Hobby
 */
@WebServlet("/Hobby.do")
public class Hobby extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<HobbyBean> beans = new ArrayList<>();
		HobbyDAO hdao = new HobbyDAO();
		
		int result=0;
		String hobbyLo = request.getParameter("hobbyLo");
		String keyword = request.getParameter("keyword");
		if ((hobbyLo == null && keyword == null) || (hobbyLo.equals("0") && keyword.equals(""))) {
			beans = hdao.getAllHobby();
		} else if(hobbyLo !=null && (keyword==null||keyword.equals(""))){
			beans = hdao.getLocationHobby(hobbyLo);
		} else if((hobbyLo==null || hobbyLo.equals("0")) && keyword!=null){
			beans = hdao.getKeywordHobby(keyword.trim());
		}else{
			beans = hdao.getKeywordLoHobby(hobbyLo,keyword.trim());
		}
		if(beans.size()==0){
			request.setAttribute("result", result);
		}
		request.setAttribute("beans", beans);
		RequestDispatcher dis = request.getRequestDispatcher("/hobby/hobby.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
