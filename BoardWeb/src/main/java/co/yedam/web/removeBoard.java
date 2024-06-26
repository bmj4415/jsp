package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class removeBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//removeBoard 메소드에 매개값으로 전달하기 위해 만듦
		BoardVO bvo = new BoardVO();
		bvo.setBoardNo(Integer.parseInt(bno));
		bvo.setTitle(title);
		bvo.setContent(content);
		
		//삭제기능 후 처리
		BoardService svc = new BoardServiceImpl();
		if(svc.removeBoard(bvo.getBoardNo())) {
			resp.sendRedirect("boardList.do");
		} else {
			req.getRequestDispatcher("WEB-INF/view/member/removeBoardForm.jsp").forward(req, resp);
		}
	}

}
