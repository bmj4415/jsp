package co.yedam.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import co.yedam.mapper.ReplyMapper;

public class AppTest {
	public static void main(String[] args) {

		SqlSession sqlSession = DataSource.getInstance().openSession(true); // openSession에 true값 : 커밋 기능을 따로 넣지 않아도
																			// 자동커밋하겠다는 뜻
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

		List<Map<String, Object>> result = mapper.centerBysido();
		for (Map<String, Object> map : result) {
			Set<String> keyset = map.keySet(); // 키값만 가지고 set에 담겠다
			System.out.println(map.get("sido") + ", " + map.get("cnt"));
			System.out.println("---------------------------------------------");
		}

//		CenterVO cvo1 = new CenterVO();
//		cvo1.setAddress("ad1");
//		cvo1.setId("1");
//		cvo1.setCenterName("cn1");
//		cvo1.setSido("sd1");
//		cvo1.setPhoneNumber("ph1");
//		
//		CenterVO cvo2 = new CenterVO();
//		cvo2.setAddress("ad2");
//		cvo2.setId("2");
//		cvo2.setCenterName("cn2");
//		cvo2.setSido("sd2");
//		cvo2.setPhoneNumber("ph2");
//		
//		CenterVO[] centers = {cvo1, cvo2};
//		int r = mapper.insertCenter(centers);
//		System.out.println(r + "건 입력");
//		

//		mapper.selectListPaging(366, 5).forEach(reply ->System.out.println(reply)); //나는 첫페이지의 글이 366이기 때문에 366으로 조회함
//		
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
