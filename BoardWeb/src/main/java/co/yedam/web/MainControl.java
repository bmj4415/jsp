package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //예외처리를 try.catch말고 맨 처음걸로해야함
		System.out.println("요청정보 : " + req + ", 응답정보 : " + resp);
		// Web-INF/public/main.jsp ==> 사용자가 main.do를 호출했을 때 main.jsp로 페이지를 재지정
		
		//자바코드에 있는 student 정보를 main.jsp 페이지에 보여주고 싶을 때
		Student student = new Student();
		student.setStdNo("S0001");
		student.setStdName("홍길동");
		student.setPhone("010-1111-2222");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class); //mapper : 인터페이스
		List<Student> list = mapper.selectBlog();//selecBlog : 추상메소드
		
		
		//객체에 속성을 지정 => "student"라는 이름으로 student라는 값을 줌
		req.setAttribute("student", student);
		req.setAttribute("studentList", list);
		
		req.getRequestDispatcher("WEB-INF/public/main.jsp").forward(req, resp);
		
		
	}

}
