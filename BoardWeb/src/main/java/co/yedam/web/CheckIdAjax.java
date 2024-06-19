package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class CheckIdAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 체크하기 위한 파라미터 값 넘겨주기
		String id = req.getParameter("id"); // id를 넣고 조회

		BoardService svc = new BoardServiceImpl();
		if (svc.checkMemberId(id)) { // {"retCode": "Exist"}
			resp.getWriter().print("{\"retCode\": \"Exist\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"Not Exist\"}");
		}
	}
}
