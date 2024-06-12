package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class RemoveForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String boardNo = req.getParameter("bno");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

		BoardService bvc = new BoardServiceImpl();
		
		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(boardNo));

		if(bvc.removeBoard(Integer.parseInt(boardNo))) {
			System.out.println("삭제완료");
			resp.sendRedirect("boardList.do");
		} else {
			System.out.println("삭제실패");
			req.getRequestDispatcher("WEB-INF/view/removeBoardForm.jsp").forward(req, resp);
			
		}
	}

}
