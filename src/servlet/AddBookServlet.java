package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddBookDAO;
import dto.BookDTO;
import sun.rmi.server.Dispatcher;

@WebServlet(urlPatterns = "/addBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddBookServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("addBook.html");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 진입!!");
		req.setCharacterEncoding("UTF-8");
		String bookName = req.getParameter("bookName");
		String publisher = req.getParameter("publisher");
		String author = req.getParameter("author");
		
		AddBookDAO dao = new AddBookDAO();
		System.out.println(bookName+","+publisher+","+author);
		dao.addBook(bookName, publisher, author);
		resp.sendRedirect("main.jsp");
		
	}

}
