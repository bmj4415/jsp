package co.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.vo.BoardVO;

/*
 * 
 */


public interface BoardMapper {
	List<BoardVO> boardList(); // 전체목록 보기
	List<BoardVO> boardListPaging(int page); //페이지별로 5건씩 보기
	int getTotalCnt();// 페이징 계산 용도(전체 페이지 수를 모르니까)
	int insertBoard(BoardVO bvo);
	int updateBoard(BoardVO bvo);
	int deleteBoard(int bno);
	BoardVO selectBoard(int bno);//단건조회
	
	//회원 아이디, 회원 비밀번호
	
	int selectMember(@Param("id") String id, @Param("pw") String pw); //갑이 여러개일때
	
	
	
}
