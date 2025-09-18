package sec01.practice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NoticeDAO noticeDAO;
	
	public void init() throws ServletException 
	{
		noticeDAO = new NoticeDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		String nextPage = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("test/html;charset=utf-8");
		String action = request.getServletPath();
		System.out.println("action:  " + action);
		
		if (action == null || action.equals("/notice.do"))
		{
			List<NoticeVO> noticeList = noticeDAO.listNotice();
			request.setAttribute("noticeList", noticeList);
			nextPage = "/test04/listNotice.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
}
