package co.yedam.book.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.book.service.BookService;
import co.yedam.book.service.BookServiceImpl;
import co.yedam.book.vo.BookVO;
import co.yedam.common.Control;

public class AddBook implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String code = req.getParameter("code");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String company = req.getParameter("company");
		String price = req.getParameter("price");
		
		BookVO bvo = new BookVO();
		
		bvo.setBookCode(code);
		bvo.setBookTitle(title);
		bvo.setAuthor(author);
		bvo.setCompany(company);
		bvo.setPrice(Integer.parseInt(price));
		
		BookService bvc = new BookServiceImpl();
		if(bvc.addBook(bvo)) {//{"retCode": "OK", "retMsg": "Success"}
			resp.getWriter().print("{\"retCode\": \"OK\", \"retMsg\": \"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"NG\", \"retMsg\": \"Fail\"}");
		}

	}

}
