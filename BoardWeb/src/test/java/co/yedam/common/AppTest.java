package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class AppTest {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//interface와 구현객체의 관계
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student std2 = new Student();
//		std2.setStdNo("S0005");
//		std2.setStdName("임꺽정");
//		std2.setPhone("010-5555-9595");
//		std2.setBldType("AB");
//		
		std2.setStdNo("S0004");
		
//		sqlSession.update("co.yedam.mapper.StudentMapper.updateStudent", std2);
//		mapper.insertStudent(std2);
//		mapper.updateStudent(std2);
		mapper.deleteStudent(std2);
		sqlSession.commit();
		
//		List<Student> list = sqlSession.selectList("co.yedam.mapper.StudentMapper.selectBlog");		
		List<Student> list = mapper.selectBlog();
		for(Student std : list) {
			System.out.println(std.toString());
		}
	}//
}//
