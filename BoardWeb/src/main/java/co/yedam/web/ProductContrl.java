package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class ProductContrl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("요청정보 : " + req + ", 응답정보 : " + resp);
		
		
		String sno = req.getParameter("stdNo"); // ?stdNo=S0001이고, =>stdNo라는 파라미터 안에 들어있는 값을 가져옴
		SqlSession sqlSession = DataSource.getInstance().openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student student = mapper.getStudent(sno);
		req.setAttribute("student", student);
		
		req.getRequestDispatcher("WEB-INF/view/product.jsp").forward(req, resp);
	}

}
