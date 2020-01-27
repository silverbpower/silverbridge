package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import dto.LoginDTO;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = dao.login(id, pw);
		RequestDispatcher dispatcher;
		HttpSession session = req.getSession();
		if(dto.isResult()) {
			req.setAttribute("name", dto.getName());
			System.out.println("Login 성공!!");
			session.setAttribute("dto", dto);
			resp.sendRedirect("main.jsp");
		}else {
			dispatcher = req.getRequestDispatcher("login_fail.html");
			dispatcher.forward(req, resp);
		}
	}
}
