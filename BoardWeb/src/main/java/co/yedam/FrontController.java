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
import co.yedam.web.AddStudent;
import co.yedam.web.BoardForm;
import co.yedam.web.BoardList;
import co.yedam.web.Getboard;
import co.yedam.web.MainControl;
import co.yedam.web.ProductContrl;
import co.yedam.web.RemoveForm;
import co.yedam.web.StudentForm;
import co.yedam.web.removeBoardForm;

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
			map.put("/removeForm.do", new removeBoardForm());
			map.put("/removeBoard.do", new RemoveForm());
		}
	
	
	
	

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
