package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		BoardService svc = new BoardServiceImpl();
		MemberVO mvo = svc.checkMember(id, pw);

		if (mvo != null) { // 아이디와 비밀번호가 모두 맞으면 서버 정보를 읽어와서 각 세션마다 다른 값을 가지고 관리하고 있기 때문에 웹브라우저마다 각자의 세션을
							// 가지고 있음(크롬으로 로그인 / 엣지: 로그인x)
			// 로그인
			HttpSession session = req.getSession();
			session.setAttribute("logId", id);

			if (mvo.getResponsibility().equals("User")) {
				resp.sendRedirect("main.do");
			} else if (mvo.getResponsibility().equals("Admin")) {
				resp.sendRedirect("memberList.do");
			} 

		} else {
			// 로그인 실패
			resp.sendRedirect("loginForm.do");
			
		}
	}
}
