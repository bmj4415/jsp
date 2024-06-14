package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.BoardMapper;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class AppTest {
	public static void main(String[] args) {
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession에 true값 : 커밋 기능을 따로 넣지 않아도 자동커밋하겠다는 뜻
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		SearchVO search = new SearchVO(1, "W", "01");
		
		mapper.boardListPaging(search).forEach(bvo -> System.out.println(bvo));

		
		
//		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		
//		//interface와 구현객체의 관계
//		
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
//		
//		List<BoardVO> list = mapper.boardListPaging(1);
//		for (BoardVO bvo : list) {
//			System.out.println(bvo.toString());
//		}
		
		
		
//		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//		
//		Student std2 = new Student();
////		std2.setStdNo("S0005");
////		std2.setStdName("임꺽정");
////		std2.setPhone("010-5555-9595");
////		std2.setBldType("AB");
////		
//		std2.setStdNo("S0004");
//		
////		sqlSession.update("co.yedam.mapper.StudentMapper.updateStudent", std2);
////		mapper.insertStudent(std2);
////		mapper.updateStudent(std2);
//		mapper.deleteStudent(std2);
//		sqlSession.commit();
//		
////		List<Student> list = sqlSession.selectList("co.yedam.mapper.StudentMapper.selectBlog");		
//		List<Student> list = mapper.selectBlog();
//		for(Student std : list) {
//			System.out.println(std.toString());
//		}
	}//
}//
