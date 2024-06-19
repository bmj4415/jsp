package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class ModifyAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");// id 조회

		BoardService svc = new BoardServiceImpl();
		if (svc.modifyAjax(id)) {
			resp.getWriter().print("{\"retCode\":\"OK\"}"); // {"retCode":"OK"}
		} else {
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}
	}
}