package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class JoinControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		BoardService svc = new BoardServiceImpl();
		
		req.setAttribute(id, svc);
		req.setAttribute(pw, svc);
		req.setAttribute(name, svc);
		
		if(svc.insertMember(id, pw, name)) {
			resp.sendRedirect("main.do");
		} else {
			resp.sendRedirect("joinForm.do");
		}

	}

}
