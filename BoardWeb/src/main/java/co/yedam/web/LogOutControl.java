package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;

public class LogOutControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(); //세션의 생명은 사용자가 세션초기화(로그아웃)하기 전까지는 지속됨(=로그인 유지)
		session.invalidate();//세션 정보 삭제(로그인한 기록이 있으면. 세션정보를 초기화(삭제)하면 로그아웃과 같음)

		resp.sendRedirect("loginForm.do");
	}

}
