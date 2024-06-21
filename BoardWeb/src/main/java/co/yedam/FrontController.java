package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.web.AddForm;
import co.yedam.web.AddReply;
import co.yedam.web.AddStudent;
import co.yedam.web.AjaxForm;
import co.yedam.web.BoardForm;
import co.yedam.web.BoardList;
import co.yedam.web.CheckIdAjax;
import co.yedam.web.Getboard;
import co.yedam.web.JoinControl;
import co.yedam.web.JoinForm;
import co.yedam.web.LogOutControl;
import co.yedam.web.LoginControl;
import co.yedam.web.LoginForm;
import co.yedam.web.MainControl;
import co.yedam.web.MemberAddAjax;
import co.yedam.web.MemberAjax;
import co.yedam.web.MemberDelAjax;
import co.yedam.web.MemberList;
import co.yedam.web.ModifyAjax;
import co.yedam.web.ModifyBoard;
import co.yedam.web.ModifyForm;
import co.yedam.web.ProductContrl;
import co.yedam.web.PublicData;
import co.yedam.web.RemoveForm;
import co.yedam.web.RemoveReply;
import co.yedam.web.ReplyList;
import co.yedam.web.ScriptForm;
import co.yedam.web.StudentForm;
import co.yedam.web.TotalCnt;
import co.yedam.web.removeBoard;

//front controller => 요청url(*.do(메인.do) => 실행컨트롤 매칭
// main.do => 프론트 컨트롤에서 /WEB-INF/public/main.jsp를 열어줌
//서블릿의 생명주기 : 객체생성 => init(최초 1번만 실행) => service => destroy

public class FrontController extends HttpServlet { // HttpServlet을 상속받았기 때문에 FrontController도 서블릿
	public Map<String, Control> map; // key : url, value : control

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
		public void init(ServletConfig config) throws ServletException {
			map.put("/main.do", new MainControl()); //요쳥하는 페이지에 따라 달라짐
			map.put("/product.do",new ProductContrl());
			
			//학생등록화면(studentForm.do)
			map.put("/studentForm.do", new StudentForm()); //실제 등록하는게 아니라 등록화면만 보여주는 메소
			map.put("/addStudent.do", new AddStudent()); //실제 db에 등록하는 메소드
			
			//Board 게시판 목록
			map.put("/boardList.do", new BoardList());
			
			//상세화면
			map.put("/getBoard.do", new Getboard());
			
			//연습 => 게시글 등록
			map.put("/addForm.do", new BoardForm());
			map.put("/addBoard.do", new AddForm());
			
			//게시글 삭제
			map.put("/removeForm.do", new RemoveForm());
			map.put("/removeBoard.do", new removeBoard());
			
			//수정 화면
			map.put("/modifyForm.do", new ModifyForm());
			map.put("/modifyBoard.do", new ModifyBoard());
			
			//로그인 화면
			map.put("/loginForm.do", new LoginForm());
			//로그인 기능
			map.put("/login.do", new LoginControl());
			//로그아웃 기능
			map.put("/logout.do", new LogOutControl());
			
//			//회원가입
			map.put("/joinForm.do", new JoinForm());//회원가입 화면
			map.put("/join.do", new JoinControl());//회원가입 기능
			
			//회원목록(관리자 템플릿)
			map.put("/memberList.do", new MemberList());
			
			//자바스크립트 연습용 페이지
			map.put("/script.do", new ScriptForm());
			
			//Ajax연습
			map.put("/ajax.do", new AjaxForm());
			map.put("/membersAjax.do", new MemberAjax());
			map.put("/addAjax.do", new MemberAddAjax());
			map.put("/checkIdAjax.do", new CheckIdAjax());
			map.put("/delAjax.do", new MemberDelAjax());
			map.put("/modifyAjax.do", new ModifyAjax());
			
			//댓글관련
			map.put("/replyListJson.do", new ReplyList()); //댓글 목록
			map.put("/removeReply.do", new RemoveReply()); //댓글 삭제
			map.put("/addReply.do", new AddReply()); //댓글 등록
			map.put("/replyTotalCnt.do", new TotalCnt());
			
			//공공데이터
			map.put("/publicData.do", new PublicData());
			
			
		
			
			
		}//
	
	

	@Override //main.do가 실행되면 서비스 메소드가 실행됨
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // http://localhost/BoardWeb/main.do
		//System.out.println("uri: " + uri); // BoardWeb/main.do
		String context = req.getContextPath();// /BoardWeb => project name.
		//System.out.println("context: " + context);
		String page = uri.substring(context.length());
		//System.out.println("page: " + page);

		Control result = map.get(page); //page=> 현재 main.do, product.do를 호출했다면 page는 product.do
		result.exec(req, resp); // exec 메소드 실행
	}
}//
