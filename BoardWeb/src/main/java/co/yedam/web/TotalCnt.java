package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.ReplyService;
import co.yedam.service.ReplyServiceImpl;

public class TotalCnt implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bno => 댓글 건수
		//댓글건수 값을 받아서 가져오면 반환해줄 값 작성
		
		String bno = req.getParameter("bno"); //bno값을 받아와서 문자 타입 bno에 저장
		
		ReplyService svc = new ReplyServiceImpl();
		int totalCnt = svc.getTotalCount(Integer.parseInt(bno));
		
		resp.getWriter().print(totalCnt);
		
		
	}

}
