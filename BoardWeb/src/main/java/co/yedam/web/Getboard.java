package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class Getboard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 정보를 읽어 게시글 번호를 조회
		// board.jsp 페이지에 출력
		
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO brd = svc.getBoard(Integer.parseInt(bno)); //파라미터로 넘겨주는 값 ex) 100
		
		req.setAttribute("board", brd);
		req.setAttribute("page", page);
		
		req.getRequestDispatcher("WEB-INF/view/board.jsp").forward(req, resp);
	}

}
