package co.yedam.book.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.book.service.BookService;
import co.yedam.book.service.BookServiceImpl;
import co.yedam.common.Control;

public class RemoveBook implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/json;charset=utf-8");

		String code = req.getParameter("id");

		// {"retCode": "OK"}

		BookService bvc = new BookServiceImpl();

		Map<String, String> map = new HashMap<>();
		Gson gson = new GsonBuilder().create();
		try {
			if (bvc.removeBook(code)) {
				map.put("retCode", "OK");
				map.put("retMsg", "성공적으로 삭제되었습니다.");
				// resp.getWriter().print("{\"retCode\": \"OK\"}");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("2");
			e.printStackTrace();
			map.put("retCode", "NG");
			map.put("retMsg", "처리중 예외가 발생했습니다.");
			// resp.getWriter().print("{\"retCode\": \"NG\"}");

		} finally {
			String json = gson.toJson(map);
			resp.getWriter().print(json);
			
		}
		
	}
}
