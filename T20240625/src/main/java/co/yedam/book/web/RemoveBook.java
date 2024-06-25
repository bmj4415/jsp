package co.yedam.book.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.service.BookService;
import co.yedam.book.service.BookServiceImpl;
import co.yedam.book.vo.BookVO;
import co.yedam.common.Control;

public class RemoveBook implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String bcode = req.getParameter("bkcode");
		
		BookService bvc = new BookServiceImpl();
		boolean book = bvc.removeBook(bcode);

		req.getRequestDispatcher("book/removeBook.tiles").forward(req, resp);
		
	}

}
