package co.yedam.service;

import java.util.List;

import co.yedam.vo.BoardVO;

/*
 * 목록, 단건조회, 등록, 수정, 삭제 기능 구현
 * 기능의 실행 => mapper에서
 */

public interface BoardService {
	List<BoardVO> boardList(int page);
	int boardTotal();
	BoardVO getBoard(int bno); //단건조회
	boolean addBoard(BoardVO bvo);
	boolean editBoard(BoardVO bvo);
	boolean removeBoard(int bno);
	
	//checkMember(id, pw)
	boolean checkMember(String id, String pw);
	
	
	
}
