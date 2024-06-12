package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardList(); // 전체목록 보기
	List<BoardVO> boardListPaging(int page); //페이지별로 5건씩 보기
	int getTotalCnt();// 페이징 계산 용도(전체 페이지 수를 모르니까)
	int insertBoard(BoardVO bvo);
	int updateBoard(BoardVO bvo);
	int deleteBoard(int bno);
	BoardVO selectBoard(int bno);//단건조회
}
