package co.yedam.book.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.book.service.BookService;
import co.yedam.book.service.BookServiceImpl;
import co.yedam.book.vo.BookVO;
import co.yedam.common.Control;

public class BookList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		BookService bvc = new BookServiceImpl();
		List<BookVO> list = bvc.bookList();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list); 
		resp.getWriter().print(json);

	}

}
