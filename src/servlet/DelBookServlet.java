package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import dto.BookDTO;

@WebServlet("/booklist.del")
public class DelBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookDAO dao = new BookDAO();
		ArrayList<BookDTO> list = dao.getBookList();
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("delBooklist.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
