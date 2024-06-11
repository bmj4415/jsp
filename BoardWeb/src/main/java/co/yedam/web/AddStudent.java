package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.service.StudentService;
import co.yedam.service.StudentServiceImpl;
import co.yedam.vo.Student;

public class AddStudent implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //ServletException, IOException 오류가 발생하면 exec를 호출한 곳으로 오류를 넘기기
		
		//사용자가 값을 넣고 저장을 누르면 받을 파라미터값
		String no = req.getParameter("sno");
		String name = req.getParameter("sname");
		String phone = req.getParameter("phone");
		String btype = req.getParameter("btype");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

		StudentService svc = new StudentServiceImpl();
		
		Student student = new Student();
		student.setStdNo(no);
		student.setStdName(name);
		student.setPhone(phone);
		student.setBldType(btype);
		
		
		if(svc.addStudent(student)) { //정상적으로 등록(1건)됐다면
			//sqlSession.commit(); //StudentService에서 자동커밋하기로 했기 때문에 필요없어짐
			System.out.println("정상등록..");
			resp.sendRedirect("main.do"); // 파라미터 값을 전달할 수는 없고 페이지만 열어줌
		} else { // 등록에 실패했다면
			System.out.println("등록실패..");
			req.setAttribute("message", "처리 중 오류가 발생했습니다...");
			req.getRequestDispatcher("WEB-INF/view/studentForm.jsp").forward(req, resp);
		}
	}

}
