package co.yedam.common;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession에 true값 : 커밋 기능을 따로 넣지 않아도 자동커밋하겠다는 뜻
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		
		SearchVO search = new SearchVO(1, "W", "01");
		
		//인터페이스의 구현해야할 메소드가 하나만 있는 인터페이스 : 함수형 인터페이스
		  //ReplyVO rvo = mapper.selectReply(24);
		  //System.out.println(rvo);
		  	ReplyVO rvo = new ReplyVO();
		  	rvo.setReply("댓글작성테스트");
		  	rvo.setReplyer("admin");
		  	rvo.setBoardNo(201);
		  	
		  	try {
		  	if(mapper.insertReply(rvo) == 1) {
		  		System.out.println("입력성공");
		  	}
		  	}catch (Exception e) {
		  		System.out.println("예외발생");
		  	}
		  	mapper.selectList(201).forEach(reply -> System.out.println(reply)); //매개값 reply를 받아서 출력
		  	
		  
		
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
