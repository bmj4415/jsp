package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class AddForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		BoardService bvc = new BoardServiceImpl();
		
		BoardVO vo = new BoardVO();
		//vo.setBoardNo(0);
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		if(bvc.addBoard(vo)) {
			System.out.println("게시글 등록");
			resp.sendRedirect("addForm.do");
		} else {
			System.out.println("등록실패");
			req.getRequestDispatcher("WEB-INF/view/addForm.jsp").forward(req, resp);		}
		
		
	}

}
