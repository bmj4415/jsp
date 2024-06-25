package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class JoinControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 파일첨부일 경우에는 multipart 요청을 처리해야함
		// Multipart요청 (1.요청정보 2.저장위치 3.파일최대크기 4.인코딩방식 5.(기존에 파일이 있는 경우)기존의 파일에 덮어쓰기 하지
		// 않도록 리네임정책

		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;
		String encoding = "utf-8";

		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy());

		String id = mr.getParameter("id");
		String pw = mr.getParameter("pw");
		String nm = mr.getParameter("name");
		String img = mr.getFilesystemName("myImage"); // 같은 파일이 있으면 바뀐 파일의 이름을 가져오는 메소드

		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setUserName(nm);
		mvo.setImage(img);

		BoardService svc = new BoardServiceImpl();
		try {
			if (svc.addMemberImage(mvo)) {
				if (req.getMethod().equals("POST")) {
					resp.sendRedirect("memberList.do");
				} else if (req.getMethod().equals("PUT")) {
					// {"retCode": "OK"}
					resp.getWriter().print("{\"retCode\": \"OK\"}");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (req.getMethod().equals("PUT")) {
				// {"retCode": "NG"}
				resp.getWriter().print("{\"retCode\": \"NG\"}");
			}
		}

	}

}
