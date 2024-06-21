package co.yedam.common;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession에 true값 : 커밋 기능을 따로 넣지 않아도 자동커밋하겠다는 뜻
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		
		mapper.selectListPaging(366, 5).forEach(reply ->System.out.println(reply)); //나는 첫페이지의 글이 366이기 때문에 366으로 조회함
		
		
		
		
//		SearchVO search = new SearchVO(1, "W", "01");
//		
//		//인터페이스의 구현해야할 메소드가 하나만 있는 인터페이스 : 함수형 인터페이스
//		  //ReplyVO rvo = mapper.selectReply(24);
//		  //System.out.println(rvo);
//		  	ReplyVO rvo = new ReplyVO();
//		  	rvo.setReply("댓글작성테스트");
//		  	rvo.setReplyer("admin");
//		  	rvo.setBoardNo(201);
//		  	
//		  	try {
//		  	if(mapper.insertReply(rvo) == 1) {
//		  		System.out.println("입력성공");
//		  	}
//		  	}catch (Exception e) {
//		  		System.out.println("예외발생");
//		  	}
//		  	mapper.selectList(201).forEach(reply -> System.out.println(reply)); //매개값 reply를 받아서 출력
		  	
		  
		

	}//
}//
