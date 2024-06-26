package co.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;

public interface BoardMapper {
	List<BoardVO> boardList(); // 전체목록 보기
	List<BoardVO> boardListPaging(SearchVO search); //페이지별로 5건씩 보기
	int getTotalCnt(SearchVO search);// 페이징 계산 용도(전체 페이지 수를 모르니까)
	int insertBoard(BoardVO bvo);
	int updateBoard(BoardVO bvo);
	int deleteBoard(int bno);
	BoardVO selectBoard(int bno);//단건조회
	
	//회원 아이디, 회원 비밀번호
	
	MemberVO selectMember(@Param("id") String id, @Param("pw") String pw); //값이 여러개일때
	
	//Ajax 연습
	List<MemberVO> memberList();
	int insertMemberAjax(MemberVO mvo);
	int selectMemberAjax(String id);//id값만 넘겨주면 되기 때문에 키값은 하나
	int delMemberAjax(String id);
	int modifyAjax(String id);
	int insertMember(MemberVO mvo);
}
